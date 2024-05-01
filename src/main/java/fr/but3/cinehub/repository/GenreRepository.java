package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;

import fr.but3.cinehub.entity.Genre;

public interface GenreRepository extends CrudRepository<Genre, Long>{
    
}
