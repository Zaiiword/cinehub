package fr.but3.cinehub.service;

import fr.but3.cinehub.entity.Review;
import fr.but3.cinehub.entity.Genre;
import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.MovieRepository;
import fr.but3.cinehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MovieRecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> recommendMovies(Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            // If the user doesn't exist or hasn't made any reviews, recommend the top rated movies
            List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                                                .collect(Collectors.toList());
            return allMovies.stream()
                    .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                    .limit(5)
                    .collect(Collectors.toList());
        }

        List<Review> userReviews = user.getReviews();
        if (userReviews.isEmpty()) {
            // If the user hasn't made any reviews, recommend the top rated movies
            List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                                                .collect(Collectors.toList());
            return allMovies.stream()
                    .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                    .limit(5)
                    .collect(Collectors.toList());
        }

        // Find the genre that the user has given the highest average rating
        List<Genre> favoriteGenres = userReviews.stream()
        .collect(Collectors.groupingBy(r -> r.getMovie().getGenres(), Collectors.averagingDouble(Review::getRating)))
        .entrySet().stream()
        .max(Map.Entry.comparingByValue())
        .get()
        .getKey();

        List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
        .collect(Collectors.toList());

       // Recommend movies that contain at least one of the user's favorite genres
        return allMovies.stream()
        .filter(m -> m.getGenres().stream().anyMatch(favoriteGenres::contains))
        .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
        .limit(5)
        .collect(Collectors.toList());
    }
}