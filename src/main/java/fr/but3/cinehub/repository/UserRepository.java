package fr.but3.cinehub.repository;

import org.springframework.data.repository.CrudRepository;
import fr.but3.cinehub.entity.User;


public interface UserRepository extends CrudRepository<User, Long> {

}
