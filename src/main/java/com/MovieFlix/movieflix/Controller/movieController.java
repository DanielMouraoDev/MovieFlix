package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Service.movieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("movieflix/movie")
@RequiredArgsConstructor
public class movieController {

    private final movieService movieService;
}
