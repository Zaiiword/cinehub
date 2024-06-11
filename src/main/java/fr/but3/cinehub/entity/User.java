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
import com.fasterxml.jackson.annotation.JsonManagedReference;
/**
 * Represents a User entity in the application.
 * Each user has a unique email address.
 *
 * @Entity annotation specifies that the class is an entity and is mapped to a database table.
 * @Data is a Lombok annotation to create all the getters, setters, equals, hash, and toString methods, based on the fields.
 * @Table specifies the details of the table that will be used to create the table in the database.
 */
@Entity
@Data
@Table(name = "app_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = "mail")
})
public class User {

    /**
     * Unique ID of the User.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    /**
     * Name of the User.
     */
    private String name;

    /**
     * First name of the User.
     */
    @Column(name = "first_name")
    private String firstName;

    /**
     * Email of the User.
     */
    private String mail;

    /**
     * Language of the User.
     */
    private String language;

    /**
     * Password of the User.
     */
    private String password;

    /**
     * Role of the User.
     */
    private String role;

    /**
     * Date when the User account was created.
     */
    @Column(name = "accout_created")
    private Date accountCreated;

    /**
     * Date of the User's last connection.
     */
    @Column(name = "last_connection")
    private Date lastConnection;

    /**
     * Profile picture of the User.
     */
    @Column(name = "profile_picture")
    private String profilePicture;

    /**
     * Watchlist of the User.
     */
    @JsonManagedReference
    @ManyToMany
    private List<Movie> watchlist;
    
    /**
     * Reviews made by the User.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    /**
     * Converts this User entity to a UserDetails object for Spring Security.
     *
     * @return a UserDetails object with the User's email, password, and authorities.
     */
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