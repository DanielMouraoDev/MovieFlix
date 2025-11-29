package com.MovieFlix.movieflix.Category.Controller.Repository;

import com.MovieFlix.movieflix.Category.Controller.Entity.category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<category, Long> {
}