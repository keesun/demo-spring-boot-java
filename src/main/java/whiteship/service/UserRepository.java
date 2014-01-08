package whiteship.service;

import org.springframework.data.jpa.repository.JpaRepository;
import whiteship.domain.User;

/**
 * @author Keesun Baik
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
