package subscription_tracker.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import subscription_tracker.entity.User;
import subscription_tracker.repository.UserRepository;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;


    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllSubscriptions(){
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }


}



