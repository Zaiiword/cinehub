package fr.but3.cinehub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.UserRepository;

@Service
public class UserDetailService   implements UserDetailsService {
    @Autowired
    UserRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = utilisateurRepository.findByMail(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé: " + username));
        return user.map(MyUserDetails::new).get();
    }
}
