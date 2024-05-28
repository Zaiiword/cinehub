package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;

import fr.but3.cinehub.entity.Genre;

/**
 * The GenreRepository interface is responsible for providing CRUD operations for the Genre entity.
 */
public interface GenreRepository extends CrudRepository<Genre, Long>{
    
}
