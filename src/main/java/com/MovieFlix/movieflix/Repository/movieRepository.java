package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.category;
import com.MovieFlix.movieflix.Entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface movieRepository extends JpaRepository<movie, Long> {

    List<movie> findMovieByCategories(List<category> categories);

    List<movie> findTop5ByOrderByRatingDesc();

}
