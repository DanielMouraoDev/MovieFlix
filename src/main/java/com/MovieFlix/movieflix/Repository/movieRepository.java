package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface movieRepository extends JpaRepository<movie, Long> {
}
