package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import wspa.groupproject.highway.model.User;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface UserRepository {

    User findById(Long id);

    List<User> findAll();

    Optional<User> findByUsername(String username);

    void saveNewUser(User user);

    void updateUser(User user);
}
