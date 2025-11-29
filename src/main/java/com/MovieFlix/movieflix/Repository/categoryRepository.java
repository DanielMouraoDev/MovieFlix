package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<category, Long> {
}