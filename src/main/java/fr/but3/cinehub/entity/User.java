package fr.but3.cinehub.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name = "app_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "mail")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String name;

    @Column(name = "first_name")
    private String firstName;

    private String mail;

    private String language;

    private String password;

    private String role;

    @Column(name = "accout_created")
    private Date accountCreated;

    @Column(name = "last_connection")
    private Date lastConnection;

    @Column(name = "profile_picture")
    private String profilePicture;

    @JsonManagedReference
    @ManyToMany
    private List<Movie> watchlist;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    public UserDetails toUserDetails() {

        List<GrantedAuthority> authorities = Stream.of(role)
            .map(r -> new SimpleGrantedAuthority(r))
            .collect(Collectors.toList());
    
        return new org.springframework.security.core.userdetails.User(
            getMail(),
            getPassword(),
            true,
            true, true, true,
            authorities
        );
    }

}