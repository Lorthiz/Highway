package wspa.groupproject.highway.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import wspa.groupproject.highway.model.Role;
import wspa.groupproject.highway.model.RoleName;
import wspa.groupproject.highway.model.User;
import wspa.groupproject.highway.repository.RoleRepository;
import wspa.groupproject.highway.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController()
public class RoleController {

    private static final String PATH = "/roles";

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping(PATH + "/{name}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Role rolesGet(@PathVariable String name) {
        for(RoleName role: RoleName.values()){
            if(role.name().equals(name)){
                return roleRepository.findByName(RoleName.valueOf(name));
            }
        }
        return null;
    }

    @PutMapping("/setPermissionsFor" + "/{id}/{permission}")
    @Secured("ROLE_ADMIN")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void setPermissions(@PathVariable Long id, @PathVariable String permission) {
        User user = userRepository.findById(id);
        Role role = rolesGet(permission);
        if(user == null || role == null){
            return;
        }
        user.setRoles(Collections.singleton(role));
        userRepository.updateUser(user);
    }

}
