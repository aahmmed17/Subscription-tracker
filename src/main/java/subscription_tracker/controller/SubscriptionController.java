package subscription_tracker.controller;

import jakarta.validation.Valid;
import subscription_tracker.entity.Subscription;
import subscription_tracker.repository.SubscriptionRepository;
import org.springframework.web.bind.annotation.*;
import subscription_tracker.service.SubscriptionService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionRepository subscriptionRepository, SubscriptionService subscriptionService){
        this.subscriptionRepository = subscriptionRepository;
        this.subscriptionService = subscriptionService;
    }


    @GetMapping
    public List<Subscription> getAllSubscriptions(){
        return subscriptionRepository.findAll();
    }

    @PostMapping
    public Subscription createSubscription(@Valid @RequestBody Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @GetMapping("/{id}")
    public Subscription getSubscriptionById(@PathVariable Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not found with id " + id));
    }

    @PutMapping("/{id}")
    public Subscription updateSubscription(@PathVariable Long id, @RequestBody Subscription updatedSubscription) {
        updatedSubscription.setId(id);
        return subscriptionRepository.save(updatedSubscription);
    }

    @DeleteMapping("/{id}")
    public void deleteSubscription(@PathVariable Long id) {
        subscriptionRepository.deleteById(id);
    }

    @GetMapping("/monthly-total")
    public BigDecimal getSubscriptionMonthlyCost(){
        return subscriptionService.calculateMonthlySpend();
    }
}
