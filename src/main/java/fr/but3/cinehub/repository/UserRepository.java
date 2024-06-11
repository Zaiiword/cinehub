package fr.but3.cinehub.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import fr.but3.cinehub.entity.User;

/**
 * The UserRepository interface provides CRUD operations for the User entity.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Finds a user by their email address.
     *
     * @param mail the email address of the user
     * @return an Optional containing the user if found, or an empty Optional if not found
     */
    Optional<User> findByMail(String mail);

}
