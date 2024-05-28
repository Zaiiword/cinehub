package fr.but3.cinehub.entity;

import lombok.Data;

/**
 * Represents a summary of a User entity in the application.
 * This summary includes a subset of the User's information.
 */
@Data
public class UserSummary {
    
    /**
     * Unique ID of the User.
     */
    private Long id;

    /**
     * Username of the User.
     */
    private String username;

    /**
     * Profile picture of the User.
     */
    private String profilePicture;

    /**
     * Language of the User.
     */
    private String language;
}
