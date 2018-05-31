package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import wspa.groupproject.highway.model.User;
import wspa.groupproject.highway.repository.UserRepository;

import java.util.List;

@RestController()
public class UserController {

    private static final String PATH = "/users";

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(PATH)
    @Secured("ROLE_ADMIN")
    public List<User> usersGET() {
        return userRepository.findAll();
    }

    @PostMapping(PATH)
    public User usersPOST() {
        return new User();
    }

    @GetMapping(PATH + "/{id}")
    public User getSingleUser() {
        return new User();
    }
}
