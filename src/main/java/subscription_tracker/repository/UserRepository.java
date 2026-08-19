package subscription_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import subscription_tracker.entity.Subscription;

public interface UserRepository extends JpaRepository<Subscription, Long> {

}
