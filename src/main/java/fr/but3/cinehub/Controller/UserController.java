package fr.but3.cinehub.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.RegisterUserDto;
import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.entity.UserSummary;
import fr.but3.cinehub.repository.MovieRepository;
import fr.but3.cinehub.repository.UserRepository;

import java.util.Optional;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    // allow only admin 
    @GetMapping("")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // allow only admin     
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
    
    // allow only admin     
    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        
        Optional<User> userOptional = userRepository.findById(id);
        if(!userOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User updatedUser = userOptional.get();

        updatedUser.setName(user.getName());
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setMail(user.getMail());
        updatedUser.setLanguage(user.getLanguage());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setRole(user.getRole());
        updatedUser.setLastConnection(user.getLastConnection());
        updatedUser.setProfilePicture(user.getProfilePicture());
        userRepository.save(updatedUser);
        return ResponseEntity.ok(updatedUser);
    }

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

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody RegisterUserDto registerUserDto) {
        User user = new User();
        user.setName(registerUserDto.getName());
        user.setFirstName(registerUserDto.getFirstName());
        user.setMail(registerUserDto.getMail());
        user.setLanguage(registerUserDto.getLanguage());
        user.setPassword(bCryptPasswordEncoder.encode(registerUserDto.getPassword()));
        user.setRole("admin");

        User savedUser = userRepository.save(user);
        System.out.println(savedUser);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/me")
    public Optional<User> getCurrentUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByMail(username);
    }

    @PostMapping("/watchlist/{id}")
    public ResponseEntity<?> toggleToWatchlist(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userRepository.findByMail(currentUserName).orElse(null);

        if (currentUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }

        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }   

        Movie movie = optionalMovie.get();

        if (currentUser.getWatchlist().contains(movie)) {
            // If the movie is already in the watchlist, remove it
            currentUser.getWatchlist().remove(movie);
        } else {
            // If the movie is not in the watchlist, add it
            currentUser.getWatchlist().add(movie);
        }
        userRepository.save(currentUser);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @DeleteMapping("/watchlist/{id}")
    public ResponseEntity<?> removeFromWatchlist(@PathVariable Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        User currentUser = userRepository.findByMail(currentUserName).orElse(null);

        if (currentUser == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isEmpty()) {
            return new ResponseEntity<>("Movie not found", HttpStatus.NOT_FOUND);
        }   

        Movie movie = optionalMovie.get();

        if (currentUser.getWatchlist().contains(movie)) {
            currentUser.getWatchlist().remove(movie);
        }
        userRepository.save(currentUser);

        return new ResponseEntity<>(currentUser, HttpStatus.OK);
    }

    @GetMapping("/isConnected")
    public boolean isConnected() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }


}