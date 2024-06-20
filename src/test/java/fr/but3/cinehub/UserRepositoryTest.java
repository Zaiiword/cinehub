package fr.but3.cinehub;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        User user = new User();
        user.setMail("test@example.com");
        // set other properties of the user

        userRepository.save(user);
    }

    @Test
    public void whenFindByMail_thenReturnUser() {
        Optional<User> found = userRepository.findByMail("test@example.com");

        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getMail()).isEqualTo("test@example.com");
    }

    @Test
    public void whenInvalidMail_thenReturnNull() {
        Optional<User> fromDb = userRepository.findByMail("doesnotexist@example.com");

        assertThat(fromDb.isPresent()).isFalse();
    }
}