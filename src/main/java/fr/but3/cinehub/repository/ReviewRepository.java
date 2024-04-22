package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;

import fr.but3.cinehub.entity.Review;

public interface ReviewRepository extends CrudRepository<Review, Long> {
    
}
