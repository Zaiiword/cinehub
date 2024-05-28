package fr.but3.cinehub.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.but3.cinehub.entity.Movie;

/**
 * The MovieRepository interface provides methods to interact with the movie data in the database.
 */
public interface MovieRepository extends CrudRepository<Movie, Long> {

    /**
     * Calculates the average rating for a movie.
     *
     * @param movieId the ID of the movie
     * @return the average rating as an Optional Double value, or an empty Optional if no ratings are found
     */
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.movie.id = :movieId")
    Optional<Double> calculateAverageRating(@Param("movieId") Long movieId);

    /**
     * Finds movies by name containing the specified query string, ignoring case.
     *
     * @param query the query string to search for in movie names
     * @return a list of movies matching the query
     */
    List<Movie> findByNameContainingIgnoreCase(String query);

}
