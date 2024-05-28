package fr.but3.cinehub.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.but3.cinehub.entity.Genre;
import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.MovieSummary;
import fr.but3.cinehub.entity.Review;
import fr.but3.cinehub.entity.ReviewRequest;
import fr.but3.cinehub.entity.User;
import fr.but3.cinehub.repository.GenreRepository;
import fr.but3.cinehub.repository.MovieRepository;
import fr.but3.cinehub.repository.ReviewRepository;
import fr.but3.cinehub.repository.UserRepository;
import fr.but3.cinehub.service.MovieRecommendationService;

/**
 * This class provides the controller for movie-related operations.
 * <p>
 * It handles HTTP requests for operations such as retrieving all genres and getting movie recommendations for a user.
 * </p>
 */
@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    MovieRecommendationService movieRecommendationService;

    
    /**
     * Retrieves all movies.
     * <p>
     * This method handles HTTP GET requests for retrieving all movies.
     * </p>
     *
     * @return a ResponseEntity containing a list of all movies and an HTTP status code
     */
    @GetMapping("")
    public ResponseEntity<List<Movie>> getAll(){
        List<Movie> CreneauDisponibles = (List<Movie>) movieRepository.findAll();
        return new ResponseEntity<>(CreneauDisponibles, HttpStatus.OK);
    }

    /**
     * Deletes a movie by its ID.
     * <p>
     * This method handles HTTP DELETE requests for deleting a movie by its ID. Only an admin can delete a movie.
     * </p>
     *
     * @param id the ID of the movie to delete
     * @return a ResponseEntity containing an HTTP status code
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {

        // allow only admin 
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> userPatch = userRepository.findByMail(username);
         if( ! userPatch.get().getRole().equals("admin")){
          return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }
          
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Movie movie = movieOptional.get();
        movieRepository.delete(movie);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Searches for movies based on a query string.
     * <p>
     * This method handles HTTP GET requests for searching movies. It finds movies whose names contain the query string, ignoring case.
     * </p>
     *
     * @param query the query string to search for in movie names
     * @return a ResponseEntity containing a list of matching movies and an HTTP status code
     */
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam("q") String query) {
        List<Movie> movies = movieRepository.findByNameContainingIgnoreCase(query);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * Retrieves a movie by its ID.
     * <p>
     * This method handles HTTP GET requests for retrieving a movie by its ID.
     * </p>
     *
     * @param id the ID of the movie to retrieve
     * @return a ResponseEntity containing the movie and an HTTP status code, or an HTTP status code of NOT_FOUND if the movie does not exist
     */
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") Long id) {
        Optional<Movie> CreneauDisponible = movieRepository.findById(id);
        if (CreneauDisponible.isPresent())
            return new ResponseEntity<>(CreneauDisponible.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    /**
     * Retrieves a summary of all movies, with an optional limit on the number of movies returned.
     * <p>
     * This method handles HTTP GET requests for retrieving a summary of all movies.
     * </p>
     *
     * @param limit an optional parameter specifying the maximum number of movies to return
     * @return a ResponseEntity containing a list of movie summaries and an HTTP status code
     */
    @GetMapping("/summary")
    public ResponseEntity<List<MovieSummary>> getAllSummary(@RequestParam(required = false) Integer limit){
        List<Movie> movies = (List<Movie>) movieRepository.findAll();
        if (limit != null) {
            movies = movies.stream()
                .limit(limit)
                .collect(Collectors.toList());
        }
        List<MovieSummary> summaries = movies.stream().map(movie -> {
            MovieSummary summary = new MovieSummary();
            summary.setId(movie.getId());
            summary.setName(movie.getName());
            summary.setGenres(movie.getGenres());
            summary.setReleased(movie.getReleased());
            summary.setPoster(movie.getPoster());
            summary.setRating(movie.getRating());
            return summary;
        }).collect(Collectors.toList());
        return new ResponseEntity<>(summaries, HttpStatus.OK);
    }

    /**
     * Adds a new movie.
     * <p>
     * This method handles HTTP POST requests for adding a new movie.
     * </p>
     *
     * @param newMovie the new movie to add
     * @return a ResponseEntity containing the added movie and an HTTP status code
     */
    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        Movie movie = movieRepository.save(newMovie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }

    /**
     * Handles the submission of a review for a movie.
     * <p>
     * This method handles HTTP POST requests for submitting a review for a movie.
     * </p>
     *
     * @param id the ID of the movie to review
     * @param reviewRequest the review to submit
     * @return a ResponseEntity containing the submitted review and an HTTP status code
     */
    @PostMapping("/{id}/review")
    public ResponseEntity<Review> handleCommentSubmit(@PathVariable String id, @RequestBody ReviewRequest reviewRequest) {
        System.out.println(reviewRequest);
        User user = userRepository.findById(reviewRequest.getUserId()).orElse(null);
        Movie movie = movieRepository.findById(Long.parseLong(id)).orElse(null);

        if (user == null || movie == null) {
            return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
        }

        Review review = new Review();
        review.setUser(user);
        review.setMovie(movie);
        review.setContent(reviewRequest.getComment());
        review.setRating(reviewRequest.getRating());

        reviewRepository.save(review);

        Double averageRating = movieRepository.calculateAverageRating(movie.getId()).orElse(0.0);
        movie.setRating(averageRating);
        movieRepository.save(movie);
        return new ResponseEntity<Review>(review, HttpStatus.CREATED);
        
    }

    /**
     * Toggles the like status of a review.
     * <p>
     * This method handles HTTP PATCH requests for toggling the like status of a review.
     * </p>
     *
     * @param idReview the ID of the review to toggle the like status of
     * @return a ResponseEntity containing the updated review and an HTTP status code
     */
    @PatchMapping("/review/{idReview}")
    public ResponseEntity<Review> toggleReviewLike(@PathVariable("idReview") Long idReview) {

        Optional<Review> reviewOptional = reviewRepository.findById(idReview);
        if (!reviewOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Review review = reviewOptional.get();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByMail(username);

        if (review.getLikedBy().contains(user.orElse(null))) {
            review.getLikedBy().remove(user.orElse(null));
        } else {
            review.getLikedBy().add(user.orElse(null));
        }

        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    /**
     * Deletes a review by its ID.
     * <p>
     * This method handles HTTP DELETE requests for deleting a review by its ID.
     * </p>
     *
     * @param idReview the ID of the review to delete
     * @return a ResponseEntity containing an HTTP status code
     */
    @DeleteMapping("/review/{idReview}")
    public ResponseEntity<?> deleteReview(@PathVariable Long idReview) {
         // allow only admin 
         String username = SecurityContextHolder.getContext().getAuthentication().getName();
         Optional<User> userPatch = userRepository.findByMail(username);
          if( ! userPatch.get().getRole().equals("admin")){
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
          }

        reviewRepository.deleteById(idReview);
        return ResponseEntity.ok().build();
    }

    /**
     * Updates a movie by its ID.
     * <p>
     * This method handles HTTP PATCH requests for updating a movie by its ID.
     * </p>
     *
     * @param id the ID of the movie to update
     * @param updatedMovie the updated movie
     * @return a ResponseEntity containing the updated movie and an HTTP status code
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie updatedMovie) {
         // allow only admin 
         String username = SecurityContextHolder.getContext().getAuthentication().getName();
         Optional<User> userPatch = userRepository.findByMail(username);
          if( ! userPatch.get().getRole().equals("admin")){
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
          }

        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        Movie movie = movieOptional.get();
        movie.setName(updatedMovie.getName());
        movie.setDuration(updatedMovie.getDuration());
        movie.setRating(updatedMovie.getRating());
        movie.setDirectors(updatedMovie.getDirectors());
        movie.setActors(updatedMovie.getActors());
        movie.setSynopsis(updatedMovie.getSynopsis());
        movie.setTrailer(updatedMovie.getTrailer());
        movie.setPoster(updatedMovie.getPoster());
        movie.setGenres(updatedMovie.getGenres());
        movie.setReleased(updatedMovie.getReleased());
        movie.setProductionCountry(updatedMovie.getProductionCountry());
        movie.setImdbId(updatedMovie.getImdbId());
        movie.setReviews(updatedMovie.getReviews());
        
        movieRepository.save(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }
    
    /**
    * Retrieves all genres.
    * <p>
    * This method handles HTTP GET requests for retrieving all genres.
    * </p>
    *
    * @return a ResponseEntity containing a list of all genres and an HTTP status code
    */
    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> genres = (List<Genre>) genreRepository.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

   
    /**
     * Retrieves movie recommendations for a user by their ID.
     * <p>
     * This method handles HTTP GET requests for retrieving movie recommendations for a user.
     * </p>
     *
     * @param userId the ID of the user to get recommendations for
     * @return a ResponseEntity containing a list of recommended movies and an HTTP status code
     */
    @GetMapping("/recommendations/{userId}")
    public ResponseEntity<List<Movie>> getRecommendations(@PathVariable("userId") Long userId) {
        List<Movie> recommendedMovies = movieRecommendationService.recommendMovies(userId, 3);
        return new ResponseEntity<>(recommendedMovies, HttpStatus.OK);
    }
}
