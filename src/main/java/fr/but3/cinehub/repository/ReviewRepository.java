package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;

import fr.but3.cinehub.entity.Review;

/**
 * The ReviewRepository interface provides CRUD operations for the Review entity.
 */
public interface ReviewRepository extends CrudRepository<Review, Long> {
    
}
