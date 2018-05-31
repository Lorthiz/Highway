package wspa.groupproject.highway.repository;

import org.springframework.stereotype.Component;
import wspa.groupproject.highway.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    private final static HashSet<User> users = new HashSet<>();

    static {
        users.add(new User(1, "Sylwester", "Wróblewski", "swr@dupadupa.com", "password", null));
        users.add(new User(2, "Second", "User", "second@dupadupa.com", "password", null));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByUsernameOrEmail(String username, String email) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
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
}
