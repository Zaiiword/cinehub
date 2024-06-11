package fr.but3.cinehub.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.but3.cinehub.entity.User;

/**
 * Custom UserDetails implementation for Spring Security.
 * This class provides the user details to Spring Security for authentication.
 */
public class MyUserDetails implements UserDetails {

    /**
     * Username of the User.
     */
    private String userName;

    /**
     * Password of the User.
     */
    private String password;

    /**
     * Authorities granted to the User.
     */
    private List<GrantedAuthority> authorities;

    /**
     * Constructs a new MyUserDetails object from a User entity.
     *
     * @param utilisateur the User entity.
     */
    public MyUserDetails(User utilisateur) {
        this.userName = utilisateur.getMail();
        this.password = utilisateur.getPassword();
        this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_"+utilisateur.getRole()));
    }

    /**
     * Returns the authorities granted to the User.
     *
     * @return a collection of GrantedAuthority.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the password of the User.
     *
     * @return the password.
     */
    @Override
    public String getPassword() {
       return password;
    }

    /**
     * Returns the username of the User.
     *
     * @return the username.
     */
    @Override
    public String getUsername() {
        return userName;
    }

    /**
     * Checks if the User's account has not expired.
     *
     * @return true if the account is valid (not expired).
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Checks if the User's account is not locked.
     *
     * @return true if the account is not locked.
     */
    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    /**
     * Checks if the User's credentials (password) have not expired.
     *
     * @return true if the credentials are valid (not expired).
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Checks if the User's account is enabled.
     *
     * @return true if the account is enabled.
     */
    @Override
    public boolean isEnabled() {
       return true;
    }
    
}