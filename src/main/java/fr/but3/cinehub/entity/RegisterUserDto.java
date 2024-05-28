package fr.but3.cinehub.entity;

import lombok.Data;

/**
 * This class represents a Data Transfer Object (DTO) for registering a new user.
 * <p>
 * It is used to encapsulate the user details provided by a user during registration.
 * </p>
 */
@Data
public class RegisterUserDto {
    /**
     * The name of the user.
     */
    private String name;

    /**
     * The first name of the user.
     */
    private String firstName;

    /**
     * The email of the user.
     */
    private String mail;

    /**
     * The preferred language of the user.
     */
    private String language;

    /**
     * The password of the user.
     */
    private String password;

    /**
     * The role of the user.
     */
    private String role;

}