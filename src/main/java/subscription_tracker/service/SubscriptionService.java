package subscription_tracker.service;

import org.springframework.stereotype.Service;
import subscription_tracker.entity.Subscription;
import subscription_tracker.repository.SubscriptionRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    public BigDecimal calculateMonthlySpend(){
        List<Subscription> allSubs = subscriptionRepository.findAll();
        BigDecimal totalMonthlySpend = BigDecimal.ZERO;

        for (Subscription sub : allSubs) {

            String billingEnum = sub.getBillingCycle().name();

            switch (billingEnum) {

                case "MONTHLY":
                    totalMonthlySpend = totalMonthlySpend.add(sub.getCost());
                    break;
                case "YEARLY":
                    totalMonthlySpend = totalMonthlySpend.add(sub.getCost().divide(BigDecimal.valueOf(12), 2, RoundingMode.CEILING));
                    break;
                case "WEEKLY":
                    totalMonthlySpend = totalMonthlySpend.add(sub.getCost().multiply(BigDecimal.valueOf(4.33))).setScale(2,RoundingMode.CEILING);
                    break;
            }

        }
        return totalMonthlySpend;
    }

}
