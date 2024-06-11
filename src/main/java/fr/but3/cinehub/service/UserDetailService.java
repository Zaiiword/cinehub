package fr.but3.cinehub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.UserRepository;

/**
 * This class implements the UserDetailsService interface and provides the implementation for loading user details by username.
 */
@Service
public class UserDetailService   implements UserDetailsService {
    @Autowired
    UserRepository utilisateurRepository;

    /**
        * Loads the user details by username.
        *
        * @param username the username of the user
        * @return the user details
        * @throws UsernameNotFoundException if the user is not found
        */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = utilisateurRepository.findByMail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé: " + username));
        return user.map(MyUserDetails::new).get();
    }
}
