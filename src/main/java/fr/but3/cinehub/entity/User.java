package fr.but3.cinehub.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

import java.util.Date;

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

}