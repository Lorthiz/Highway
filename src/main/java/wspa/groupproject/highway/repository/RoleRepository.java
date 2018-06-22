package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wspa.groupproject.highway.model.Role;
import wspa.groupproject.highway.model.RoleName;

@Repository
@Transactional
public interface RoleRepository {
    Role findByName(RoleName roleName);
}