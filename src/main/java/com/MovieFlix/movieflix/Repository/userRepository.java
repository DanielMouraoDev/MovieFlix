package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;


public interface userRepository extends JpaRepository<user, Long> {
}
