package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import wspa.groupproject.highway.model.Vehicle;
import wspa.groupproject.highway.repository.VehicleRepository;

import java.util.List;

@RestController()
public class VehicleController {

    private static final String PATH = "/vehicles";

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping(PATH)
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<Vehicle> vehiclesGet() {
        return vehicleRepository.findAll();
    }

    @PutMapping(PATH + "/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void changeStatus(@PathVariable Long id) {
        vehicleRepository.changeStatus(id);
    }

    @PostMapping(PATH)
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void usersPOST(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
