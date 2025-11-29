package com.MovieFlix.movieflix.Service;

import com.MovieFlix.movieflix.Repository.movieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class movieService {

    private final movieRepository movieRepository;
}
