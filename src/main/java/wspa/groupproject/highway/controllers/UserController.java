package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import wspa.groupproject.highway.model.Role;
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
    public List<User> usersGET() {
        return userRepository.findAll();
    }

    @PostMapping(PATH)
    public void usersPOST(@RequestBody User user) {
        user.setRoles(Collections.singleton(roleRepository.findByName(RoleName.ROLE_USER)));
        System.out.print(user);
        userRepository.saveNewUser(user);
    }

    @GetMapping(PATH + "/{id}")
    @Secured("ROLE_ADMIN")
    public User getSingleUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }
}
