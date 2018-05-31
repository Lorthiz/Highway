package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import wspa.groupproject.highway.model.Role;
import wspa.groupproject.highway.model.RoleName;

import java.util.Optional;

@Repository
public interface RoleRepository {
    Optional<Role> findByName(RoleName roleName);
}