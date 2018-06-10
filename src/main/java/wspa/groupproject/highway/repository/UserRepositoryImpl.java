package wspa.groupproject.highway.repository;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import wspa.groupproject.highway.model.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return getSession().createQuery("from User", User.class).getResultList();
    }

    @Override
    public List<User> findByIdIn(List<Long> userIds) {
        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByUsername(String username) {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public void saveNewUser(User user) {
        getSession().save(user);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
