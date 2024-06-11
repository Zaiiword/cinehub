package fr.but3.cinehub.service;

import fr.but3.cinehub.entity.Review;
import fr.but3.cinehub.entity.Genre;
import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.GenreRepository;
import fr.but3.cinehub.repository.MovieRepository;
import fr.but3.cinehub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Service for recommending movies to a user.
 *
 * @Service annotation is used with classes that provide some business functionalities.
 */
@Service
public class MovieRecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private GenreRepository genreRepository;


    /**
     * Recommends movies to a user based on their rates and the genres of the movies a given user has reviewed.
     * It's based on an K-NN algorithm. The distance between the rating of the movies, user's genre ratings and the genres of each movie is calculated to recommend the bests ones.
     * 
     * @param userId the ID of the user.
     * @param k the number of movies to recommend.
     * @return a list of recommended movies.
     */
    public List<Movie> recommendMovies(Long userId, int k) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null || user.getReviews().isEmpty()) {
            // If the user doesn't exist or hasn't made any reviews, recommend the most popular movies
            List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
                                                .collect(Collectors.toList());
            return allMovies.stream()
                    .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
                    .limit(k)
                    .collect(Collectors.toList());
        }
    
        List<Review> userReviews = user.getReviews();
        List<Movie> reviewedMovies = userReviews.stream().map(Review::getMovie).collect(Collectors.toList());
    
        // Find the average rating that the user has given to each genre
        Map<Genre, Double> userGenreRatings = userReviews.stream()
            .flatMap(r -> r.getMovie().getGenres().stream().map(g -> new AbstractMap.SimpleEntry<>(g, r.getRating())))
            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.averagingDouble(Map.Entry::getValue)));
        
            // Add default rating for genres not rated by the user
        List<Genre> allGenres = StreamSupport.stream(genreRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
        for (Genre genre : allGenres) {
            userGenreRatings.putIfAbsent(genre, 2.5);
        }
        System.out.println("BBBBBBBBBBBBBBBBBB");
        System.out.println(userGenreRatings);


        List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    
        // Recommend movies that have the smallest distance to the user's genre ratings
        return allMovies.stream()
            .filter(movie -> !reviewedMovies.contains(movie))
            .sorted((m1, m2) -> {
                // Calculate the distance between the user's genre ratings and the genres of each movie
                double distance1 = calculateDistance(userGenreRatings, m1);
                double distance2 = calculateDistance(userGenreRatings, m2);
                return Double.compare(distance1, distance2);
            })
            .limit(k)
            .collect(Collectors.toList());
    }
    
    /**
     * Calculates the distance between a movie rating, a user's genre ratings and a movie's genres.
     *
     * @param userGenreRatings the user's average ratings for each genre.
     * @param movie the movie.
     * @return the distance.
     */
    private double calculateDistance(Map<Genre, Double> userGenreRatings, Movie movie) {
        double distance = 0.0;
        List<Genre> movieGenres = movie.getGenres();
        for (Map.Entry<Genre, Double> entry : userGenreRatings.entrySet()) {
            Genre genre = entry.getKey();
            double rating = entry.getValue();
            if (movieGenres.contains(genre)) {
                // If the movie has this genre, decrease the distance by the user's rating for this genre
                // Adjust if the movie has multiple genres
                distance -= (rating + movie.getRating()) / (2 * movieGenres.size());
            } 
        }
        System.out.println(movie + " " + distance);
        return distance;
    }

















    // public List<Movie> recommendMovies(Long userId) {
    //     User user = userRepository.findById(userId).orElse(null);
    //     if (user == null || user.getReviews().isEmpty()) {
    //         // If the user doesn't exist or hasn't made any reviews, recommend the top rated movies
    //         List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
    //                                             .collect(Collectors.toList());
    //         return allMovies.stream()
    //                 .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
    //                 .limit(3)
    //                 .collect(Collectors.toList());
    //     }
    
    //     List<Review> userReviews = user.getReviews();
    //     List<Movie> reviewedMovies = userReviews.stream().map(Review::getMovie).collect(Collectors.toList());
    
    //     // Find the genre that the user has given the highest average rating
    //     List<Genre> favoriteGenres = userReviews.stream()
    //         .collect(Collectors.groupingBy(r -> r.getMovie().getGenres(), Collectors.averagingDouble(Review::getRating)))
    //         .entrySet().stream()
    //         .max(Map.Entry.comparingByValue())
    //         .get()
    //         .getKey();
    
    //     List<Movie> allMovies = StreamSupport.stream(movieRepository.findAll().spliterator(), false)
    //         .collect(Collectors.toList());
    
    //    // Recommend movies that contain at least one of the user's favorite genres
    //     return allMovies.stream()
    //         .filter(m -> m.getGenres().stream().anyMatch(favoriteGenres::contains))
    //         .filter(movie -> !reviewedMovies.contains(movie))
    //         .sorted((m1, m2) -> Double.compare(m2.getRating(), m1.getRating()))
    //         .limit(3)
    //         .collect(Collectors.toList());
    // }
}