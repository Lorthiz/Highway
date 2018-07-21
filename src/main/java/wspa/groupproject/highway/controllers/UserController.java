package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import wspa.groupproject.highway.model.RoleName;
import wspa.groupproject.highway.model.User;
import wspa.groupproject.highway.repository.RoleRepository;
import wspa.groupproject.highway.repository.UserRepository;

import java.util.Collections;
import java.util.List;

@RestController()
public class UserController {

    private static final String PATH = "/users";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(PATH)
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public List<User> usersGET() {
        return userRepository.findAll();
    }

    @PostMapping(PATH)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void usersPOST(@RequestBody User user) {
        user.setRoles(Collections.singleton(roleRepository.findByName(RoleName.ROLE_USER)));
        userRepository.saveNewUser(user);
    }

    @GetMapping(PATH + "/{id}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public User getSingleUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }

    @GetMapping(PATH + "/currentUser")
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userRepository.findByUsername(authentication.getName()).orElse(null);
    }

    @PutMapping(PATH)
    @Secured({"ROLE_ADMIN", "ROLE_INSTRUCTOR", "ROLE_USER"})
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateUser(@RequestBody User user) {
        User updated = getCurrentUser();
        updated.setPassword(user.getPassword());
        updated.setEmail(user.getEmail());
        userRepository.updateUser(updated);
    }
}
