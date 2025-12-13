package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; // É bom adicionar essa anotação

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {

    Optional<user> findByEmail(String email);
}