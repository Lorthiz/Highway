package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import wspa.groupproject.highway.model.Ride;
import wspa.groupproject.highway.model.User;
import wspa.groupproject.highway.repository.RideRepository;
import wspa.groupproject.highway.repository.UserRepository;

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

    @GetMapping(PATH)
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<Ride> usersForAdminGET() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        Long userId = userRepository.findByUsername(authentication.getName()).map(User::getId).orElse(null);
        if (roles.contains("ROLE_ADMIN")) {
            return rideRepository.findAll();
        } else if (roles.contains("ROLE_INSTRUCTOR")) {
            return rideRepository.findByInstructorId(userId);
        } else if (roles.contains("ROLE_USER")) {
            return rideRepository.findByStudentId(userId);
        }
        return Collections.emptyList();
    }

}
