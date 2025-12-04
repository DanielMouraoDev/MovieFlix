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

    @PostMapping
    public ResponseEntity<movieResponse> saveMovie(@RequestBody movieRequest request) {
        movie movieEntity = movieMapper.toMovie(request);
        movie savedMovie = movieService.saveMovie(movieEntity);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(movieMapper.toMovieResponse(savedMovie));
    }

    @GetMapping
    public ResponseEntity<List<movieResponse>> findAll() {
        List<movieResponse> movies = movieService.findAll()
                .stream()
                .map(movieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<movieResponse> findById(@PathVariable Long id) {
        return movieService.findById(id)
                .map(movie -> ResponseEntity.ok(movieMapper.toMovieResponse(movie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<movieResponse> update(@PathVariable Long id, @RequestBody movieRequest request) {
        movie movieToUpdate = movieMapper.toMovie(request);
        return movieService.update(id, movieToUpdate)
                .map(updatedMovie -> ResponseEntity.ok(movieMapper.toMovieResponse(updatedMovie)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<movieResponse>> findByCategories(@RequestParam Long category) {
        List<movieResponse> movies = movieService.findByCategory(category)
                .stream()
                .map(movieMapper::toMovieResponse)
                .toList();

        return ResponseEntity.ok(movies);
    }
}