package fr.but3.cinehub.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.but3.cinehub.entity.Movie;
import fr.but3.cinehub.entity.MovieSummary;
import fr.but3.cinehub.repository.MovieRepository;

@CrossOrigin
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAll(){
        List<Movie> CreneauDisponibles = (List<Movie>) movieRepository.findAll();
        return new ResponseEntity<>(CreneauDisponibles, HttpStatus.OK);
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
        summary.setDirectors(movie.getDirectors());
        summary.setGenres(movie.getGenres());
        summary.setReleased(movie.getReleased());
        return summary;
    }).collect(Collectors.toList());
    return new ResponseEntity<>(summaries, HttpStatus.OK);
}

    
}
