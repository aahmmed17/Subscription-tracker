package subscription_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import subscription_tracker.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
