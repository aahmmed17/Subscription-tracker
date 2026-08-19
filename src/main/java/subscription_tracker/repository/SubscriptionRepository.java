package subscription_tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import subscription_tracker.entity.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

}
