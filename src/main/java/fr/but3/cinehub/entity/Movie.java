package fr.but3.cinehub.entity;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * This class represents a movie in the movie database.
 * <p>
 * It is mapped to the "movie" table in the database.
 * Each movie has an ID, title, actors, synopsis, trailer, poster, genres, release date, production country, and an IMDb ID.
 * </p>
 */
@Entity
@Data
@Table(name = "movie")
public class Movie {

    /**
     * The ID of the movie.
     * <p>
     * This is the primary key in the "movie" table.
     * It is automatically generated.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The name of the movie.
     */
    private String name;

    /**
     * The duration of the movie in minutes.
     */
    private Integer duration;

    /**
     * The rating of the movie.
     */
    private double rating;

    /**
     * The directors of the movie.
     */
    private String directors;

    /**
     * The actors in the movie.
     */
    private String actors;

    /**
     * The synopsis of the movie.
     */
    private String synopsis;

    /**
     * The trailer URL of the movie.
     */
    private String trailer;

    /**
     * The poster URL of the movie.
     */
    private String poster;

    /**
     * The list of genres associated with this movie.
     * <p>
     * This is a many-to-many relationship.
     * The relationship is mapped by the "genres" field in the Genre class.
     * </p>
     */
    @ManyToMany
    @JoinTable(
        name = "movie_genre",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    /**
     * The release date of the movie.
     */
    private Date released;

    /**
     * The production country of the movie.
     */
    private String productionCountry;

    /**
     * The IMDb ID of the movie.
     */
    @Column(name = "imdb_id")
    private String imdbId;

    /**
     * The list of reviews associated with this movie.
     */
    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    /**
     * Returns a string representation of the movie.
     *
     * @return a string representation of the movie
     */
    @Override
    public String toString() {
        return "Movie [id=" + id + ", name=" + name + "]";
    }

    
}