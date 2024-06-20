package fr.but3.cinehub;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.Review;
import fr.but3.cinehub.repository.MovieRepository;
import fr.but3.cinehub.repository.ReviewRepository;

@DataJpaTest
// @AutoConfigureTestDatabase(replace = Replace.NONE)
public class MovieRepositoryTest {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    private Movie movie;

    @BeforeEach
    public void setUp() {
        // Set up test data
        movie = new Movie();
        movie.setName("Test Movie");
        movieRepository.save(movie);

        Review review1 = new Review();
        review1.setMovie(movie);
        review1.setRating((float) 4.0);
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setMovie(movie);
        review2.setRating((float) 5.0);
        reviewRepository.save(review2);

    }

    @Test
    public void testCalculateAverageRating() {
        Optional<Double> averageRating = movieRepository.calculateAverageRating(movie.getId());
        assertThat(averageRating).isPresent();
        assertThat(averageRating.get()).isEqualTo(4.5);
    }

    @Test
    public void testFindByNameContainingIgnoreCase() {
        List<Movie> movies = movieRepository.findByNameContainingIgnoreCase("test");
        assertThat(movies).hasSize(1);
        assertThat(movies.get(0).getName()).isEqualTo("Test Movie");
    }
}
