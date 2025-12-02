package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.movieRequest;
import com.MovieFlix.movieflix.Controller.Response.movieResponse;
import com.MovieFlix.movieflix.Entity.movie;
import com.MovieFlix.movieflix.Mapper.movieMapper;
import com.MovieFlix.movieflix.Service.movieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/movie")
@RequiredArgsConstructor
public class movieController {

    private final movieService movieService;

    @GetMapping
    public ResponseEntity<List<movieResponse>> getAllMovies() {
        List<movieResponse> movies = movieService.findAll()
                .stream()
                .map(movieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<movieResponse> saveMovie(@RequestBody movieRequest request) {
        movie newMovie = movieMapper.toMovie(request);

        movie savedMovie = movieService.saveMovie(newMovie);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping("/{id}")
    public ResponseEntity<movieResponse> getMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(movieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}