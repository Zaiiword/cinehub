package fr.but3.cinehub.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/**
 * This class represents a review in the movie database.
 * <p>
 * It is mapped to the "review" table in the database.
 * Each review has an ID, a user who wrote the review, a movie the review is for, and the content of the review.
 * </p>
 */
@Entity
@Data
public class Review {
    /**
     * The ID of the review.
     * <p>
     * This is the primary key in the "review" table.
     * It is automatically generated.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The user who wrote the review.
     * <p>
     * This is a many-to-one relationship.
     * The relationship is mapped by the "reviews" field in the User class.
     * </p>
     */
    @JsonIgnoreProperties("reviews")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    /**
     * The movie the review is for.
     * <p>
     * This is a many-to-one relationship.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Movie movie;
    /**
     * The content of the review.
     */
    private String content;
    /**
     * The rating of the review.
     */
    private float rating;
    /**
     * The list of users who liked the review.
     * <p>
     * This is a many-to-many relationship.
     * The relationship is mapped by the "likedBy" field in the User class.
     * </p>
     */
    @ManyToMany
    private List<User> likedBy;
}