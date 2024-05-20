
package com.mali.movies.controllers;

import com.mali.movies.models.Movie;
import com.mali.movies.repository.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Jose Maria
 */

@RestController
@RequestMapping("/api/movies")

public class MovieController {
    
    @Autowired
    private MovieRepository movieRepository;
    
    // mostrar todas las peliculas..
    @CrossOrigin
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
    
    // obtener datos de una pelicula mediante el id.
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Optional<Movie> movie = movieRepository.findById(id);
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // insercción de peliculas
    @CrossOrigin
    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie savedMovie = movieRepository.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMovie);
    }
    
    //Borrado de peliculas
    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        movieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    // Actualizar una pelicula
    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updateMovie) {
        if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updateMovie.setId(id);
        Movie savedMovie = movieRepository.save(updateMovie);
        return ResponseEntity.ok(savedMovie);
    }
    
    //votar una pelicula
    @CrossOrigin
    @GetMapping("/vote/{id}/{rating}")
    public ResponseEntity<Movie> voteMovie(@PathVariable Long id, @PathVariable double rating) {
      if(!movieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
      Optional<Movie> optional = movieRepository.findById(id);
      Movie movie = optional.get();
      //movie.rating puntuación actual.
      //movie.votes numero total de votos.
      double newRating =  ((movie.getVotes() * movie.getRating()) +rating ) / (movie.getVotes() +1);
      
      movie.setVotes(movie.getVotes() + 1);
      movie.setRating(newRating);
      Movie savedMovie = movieRepository.save(movie);
      return ResponseEntity.ok(savedMovie);
    
    }
}
