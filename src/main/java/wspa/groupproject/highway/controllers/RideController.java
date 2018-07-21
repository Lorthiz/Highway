package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import wspa.groupproject.highway.model.*;
import wspa.groupproject.highway.repository.RideRepository;
import wspa.groupproject.highway.repository.UserRepository;
import wspa.groupproject.highway.repository.VehicleRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class RideController {

    private static final String PATH = "/rides";

    @Autowired
    private RideRepository rideRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(PATH)
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<Ride> usersForAdminGET() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Long userId = getCurrentUserId();
        if (roles.contains("ROLE_ADMIN")) {
            return rideRepository.findAll();
        } else if (roles.contains("ROLE_INSTRUCTOR") || roles.contains("ROLE_USER")) {
            return rideRepository.findByUserId(userId);
        }
        return Collections.emptyList();
    }

    @GetMapping(PATH + "/conf")
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public RideConfiguration getAvaliableConf() {
        List<User> instructors = userRepository.findAll().stream()
                .filter(this::isInstructor)
                .filter(this::isNotSelf)
                .collect(Collectors.toList());
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return new RideConfiguration(instructors, vehicles);
    }

    @PostMapping(PATH)
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.CREATED)
    public void bookARide(@RequestBody CreateRideRequest rideRequest) {
        Ride ride = new Ride();
        ride.setStudent(getCurrentUser());
        ride.setInstructor(userRepository.findById(rideRequest.getInstructorId()));
        ride.setLength(60);
        ride.setStartTime(rideRequest.getStartTime());
        ride.setVehicle(vehicleRepository.findById(rideRequest.getVehicleId()));
        rideRepository.save(ride);
    }

    @DeleteMapping(PATH + "/{id}")
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.OK)
    public void bookARide(@PathVariable Long id) {
        rideRepository.deleteById(id);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName()).orElse(null);
    }

    private Long getCurrentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName()).map(User::getId).orElse(null);
    }

    private boolean isInstructor(User user) {
        return user.getRoles().stream()
                .map(Role::getName)
                .anyMatch(RoleName.ROLE_INSTRUCTOR::equals);
    }

    private boolean isNotSelf(User user) {
        Long userId = getCurrentUserId();
        return user.getId() != userId;
    }

}
