package fr.but3.cinehub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import fr.but3.cinehub.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.movie.id = :movieId")
    Optional<Double> calculateAverageRating(@Param("movieId") Long movieId);
}
