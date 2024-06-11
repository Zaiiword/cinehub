package fr.but3.cinehub.entity;

import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * Represents a summary of a movie.
 */
@Data
public class MovieSummary {
    /**
     * The unique identifier of the movie.
     */
    private Long id;

    /**
     * The name of the movie.
     */
    private String name;

    /**
     * The genres associated with the movie.
     */
    private List<Genre> genres;

    /**
     * The release date of the movie.
     */
    private Date released;

    /**
     * The URL of the movie's poster.
     */
    private String poster;

    /**
     * The rating of the movie.
     */
    private double rating;
}
