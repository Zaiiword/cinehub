package fr.but3.cinehub;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fr.but3.cinehub.entity.Review;
import fr.but3.cinehub.repository.ReviewRepository;

@DataJpaTest
public class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    public void testFindAll() {
        List<Review> reviews = (List<Review>) reviewRepository.findAll();
        assertThat(reviews).isNotEmpty();
    }
}