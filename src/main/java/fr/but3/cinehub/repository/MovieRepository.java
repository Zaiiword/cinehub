package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;

import fr.but3.cinehub.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {

}
