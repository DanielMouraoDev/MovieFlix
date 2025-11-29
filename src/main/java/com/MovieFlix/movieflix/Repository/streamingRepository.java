package com.MovieFlix.movieflix.Repository;

import com.MovieFlix.movieflix.Entity.streaming;
import com.sun.jdi.LongValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface streamingRepository extends JpaRepository<streaming, Long> {
}
