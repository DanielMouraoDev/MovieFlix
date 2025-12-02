package com.MovieFlix.movieflix.Mapper;

import com.MovieFlix.movieflix.Controller.Request.movieRequest;
import com.MovieFlix.movieflix.Controller.Response.categoryResponse;
import com.MovieFlix.movieflix.Controller.Response.movieResponse;
import com.MovieFlix.movieflix.Controller.Response.streamingResponse;
import com.MovieFlix.movieflix.Entity.category;
import com.MovieFlix.movieflix.Entity.movie;
import com.MovieFlix.movieflix.Entity.streaming;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class movieMapper {

    public static movie toMovie(movieRequest request) {

        List<category> categories = request.categories().stream()
                .map(categoryId -> category.builder().id(categoryId).build())
                .toList();

        List<streaming> streamings = request.streamings().stream()
                .map(streamingId -> streaming.builder().id(streamingId).build())
                .toList();

        return movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releasedate())
                .rating(request.rating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static movieResponse toMovieResponse(movie movie) {

        List<categoryResponse> categories = movie.getCategories().stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();

        List<streamingResponse> streamings = movie.getStreamings().stream()
                .map(streamingMapper::tostreamingResponse)
                .toList();

        return movieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rating(movie.getRating())
                .categories(categories)
                .streamings(streamings)
                .build();
    }
}