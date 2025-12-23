package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.movieRequest;
import com.MovieFlix.movieflix.Controller.Response.movieResponse;
import com.MovieFlix.movieflix.Entity.movie;
import com.MovieFlix.movieflix.Mapper.movieMapper;
import com.MovieFlix.movieflix.Service.movieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flix/movie")
@RequiredArgsConstructor
public class movieController {

    private final movieService movieService;

    @GetMapping
    public ResponseEntity<List<movieResponse>> findAllMovies() {
        return ResponseEntity.ok(movieService.findAll()
                .stream()
                .map(movie -> movieMapper.toMovieResponse(movie))
                .toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<movieResponse> findMovieById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(movieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<movieResponse>> findMoviesByCategoryId(@RequestParam Long category) {
        List<movieResponse> list = movieService.findByCategory(category).stream()
                .map(movie -> movieMapper.toMovieResponse(movie))
                .toList();
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<movieResponse> createMovie(@Valid @RequestBody movieRequest request) {
        movie movie = movieMapper.toMovie(request);
        movie savedMovie = movieService.save(movie);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movieMapper.toMovieResponse(savedMovie));
    }

    @PutMapping
    public ResponseEntity<movieResponse> updateMovie(@Valid @RequestBody movieRequest request) {
        movie movie = movieMapper.toMovie(request);
        return movieService.update(movie)
                .map(m -> ResponseEntity.ok(movieMapper.toMovieResponse(m)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
