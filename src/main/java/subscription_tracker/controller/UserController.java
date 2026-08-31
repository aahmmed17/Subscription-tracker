//package subscription_tracker.controller;
//
//
//import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.*;
//import subscription_tracker.entity.Subscription;
//import subscription_tracker.repository.UserRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/subscriptions")
//public class UserController {
//
//    private final UserRepository userRepository;
//
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping
//    public List<Subscription> getAllSubscriptions(){
//        return userRepository.findAll();
//    }
//
//    @PostMapping
//    public Subscription createSubscription(@Valid @RequestBody Subscription subscription) {
//        return userRepository.save(subscription);
//    }
//
//    @GetMapping("/{id}")
//    public Subscription getSubscriptionById(@PathVariable Long id) {
//        return userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
//    }
//
//    @PutMapping("/{id}")
//    public Subscription updateSubscription(@PathVariable Long id, @RequestBody Subscription updatedSubscription) {
//        updatedSubscription.setId(id);
//        return userRepository.save(updatedSubscription);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteSubscription(@PathVariable Long id) {
//        userRepository.deleteById(id);
//    }
//
//
//}
//
//
//
