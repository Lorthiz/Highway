package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import wspa.groupproject.highway.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findByEmail(String email);

    User findById(Long id);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List findAll();

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    void saveNewUser(User user);
}
