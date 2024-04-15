package fr.but3.cinehub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.entity.UserSummary;
import fr.but3.cinehub.repository.UserRepository;

import java.util.Optional;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable Long id) {
        return userRepository.findById(id);
    }
    @GetMapping("/summary/{id}")
    public UserSummary getUserSummary(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        UserSummary userSummary = new UserSummary();
        userSummary.setUsername(user.getName());
        // Set other non-sensitive properties...
        return userSummary;
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }


    @GetMapping("/isConnected")
    public boolean isConnected() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userUpdates) {
        return userRepository.findById(id)
            .map(user -> {
                // update fields from userUpdates
                // ...
                return userRepository.save(user);
            })
            .orElseGet(() -> {
                userUpdates.setId(id);
                return userRepository.save(userUpdates);
            });
    }
}