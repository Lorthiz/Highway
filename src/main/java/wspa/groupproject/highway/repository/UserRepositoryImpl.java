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
    public User findById(Long id) {
        return getSession().get(User.class, id);
    }

    @Override
    public List<User> findAll() {
        return getSession().createQuery("from User", User.class).getResultList();
    }

    @Override
    public Optional<User> findByUsername(String username) {
        String hql = "from User U where U.username = :username";
        return Optional.of(getSession().createQuery(hql, User.class)
                .setParameter("username", username)
                .getSingleResult());
    }

    @Override
    public void saveNewUser(User user) {
        getSession().save(user);
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}
