package fr.but3.cinehub.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAll(){
        List<Movie> CreneauDisponibles = (List<Movie>) movieRepository.findAll();
        return new ResponseEntity<>(CreneauDisponibles, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam("q") String query) {
        List<Movie> movies = movieRepository.findByNameContainingIgnoreCase(query);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getById(@PathVariable("id") Long id) {
        Optional<Movie> CreneauDisponible = movieRepository.findById(id);
        if (CreneauDisponible.isPresent())
            return new ResponseEntity<>(CreneauDisponible.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

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

    @PostMapping("")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie newMovie) {
        Movie movie = movieRepository.save(newMovie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }


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


    @PatchMapping("/{id}/review/{idReview}")
    public ResponseEntity<Review> toggleReviewLike(@PathVariable("id") Long id, @PathVariable("idReview") Long idReview, @RequestBody Optional<User> user) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Review> reviewOptional = reviewRepository.findById(idReview);
        if (!reviewOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Review review = reviewOptional.get();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        user = userRepository.findByMail(username);
        // Check if the user is already in the likedBy list
        if (review.getLikedBy().contains(user.orElse(null))) {
            // If yes, remove the user from the list
            review.getLikedBy().remove(user.orElse(null));
        } else {
            // If not, add the user to the list
            review.getLikedBy().add(user.orElse(null));
        }

        reviewRepository.save(review);
        return new ResponseEntity<>(review, HttpStatus.OK);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable("id") Long id, @RequestBody Movie updatedMovie) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (!movieOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Movie existingMovie = movieOptional.get();
        if (updatedMovie.getName() != null) {
            existingMovie.setName(updatedMovie.getName());
        }
        if (updatedMovie.getDuration() != null) {
            existingMovie.setDuration(updatedMovie.getDuration());
        }

        movieRepository.save(existingMovie);
        return new ResponseEntity<>(existingMovie, HttpStatus.OK);
    }

    @GetMapping("/genres")
    public ResponseEntity<List<Genre>> getAllGenres() {
        List<Genre> genres = (List<Genre>) genreRepository.findAll();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    // not used to calculate in the client side
    @GetMapping("/genre/{genreId}")
    public ResponseEntity<List<Movie>> getMoviesByGenre(@PathVariable Long genreId) {
        Optional<Genre> optionalGenre = genreRepository.findById(genreId);
        if (optionalGenre == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Genre genre = optionalGenre.get();
        return new ResponseEntity<>(genre.getMovies(), HttpStatus.OK);
    }
}
