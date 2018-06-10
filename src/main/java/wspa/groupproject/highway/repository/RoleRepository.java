package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import wspa.groupproject.highway.model.Role;
import wspa.groupproject.highway.model.RoleName;

@Repository
public interface RoleRepository {
    Role findByName(RoleName roleName);
}