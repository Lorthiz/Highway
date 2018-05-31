package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Repository;
import wspa.groupproject.highway.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findAll();

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
