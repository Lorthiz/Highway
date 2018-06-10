package wspa.groupproject.highway.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wspa.groupproject.highway.model.Role;
import wspa.groupproject.highway.model.RoleName;

import javax.persistence.EntityManager;

@Component
public class RoleRepositoryImpl implements RoleRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Role findByName(RoleName roleName) {
        return getSession().get(Role.class, 1L);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
