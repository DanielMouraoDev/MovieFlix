package com.MovieFlix.movieflix.Service;

import com.MovieFlix.movieflix.Entity.category;
import com.MovieFlix.movieflix.Entity.movie;
import com.MovieFlix.movieflix.Entity.streaming;
import com.MovieFlix.movieflix.Repository.movieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class movieService {

    private final movieRepository movieRepository;
    private final categoryService categoryService;
    private final streamingService streamingService;

    public movie saveMovie(movie movie) {
        movie.setCategories(this.findCategories(movie.getCategories()));
        movie.setStreamings(this.findStreamings(movie.getStreamings()));
        return movieRepository.save(movie);
    }

    public List<movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<movie> findById(Long id) {
        return movieRepository.findById(id);
    }

    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

    private List<category> findCategories(List<category> categories) {
        List<category> categoriesFound = new ArrayList<>();
        if (categories != null) {
            categories.forEach(category ->
                    categoryService.findById(category.getId())
                            .ifPresent(categoriesFound::add));
        }
        return categoriesFound;
    }

    private List<streaming> findStreamings(List<streaming> streamings) {
        List<streaming> streamingsFound = new ArrayList<>();
        if (streamings != null) {
            streamings.forEach(streaming ->
                    streamingService.findById(streaming.getId())
                            .ifPresent(streamingsFound::add));
        }
        return streamingsFound;
    }
}