package th.ac.mahidol.ict.gemini_login.repository;
import th.ac.mahidol.ict.gemini_login.entity.User;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}

