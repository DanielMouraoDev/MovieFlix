package com.MovieFlix.movieflix.Service;


import com.MovieFlix.movieflix.Entity.streaming;
import com.MovieFlix.movieflix.Repository.streamingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class streamingService {

    private final streamingRepository streamingRepository;

    public List<streaming> findAll() {
        return streamingRepository.findAll();
    }

    public Optional<streaming> findById(Long id) {
        return streamingRepository.findById(id);
    }

    public streaming save(streaming streaming) {
        return streamingRepository.save(streaming);
    }

    public void delete(Long id) {
        streamingRepository.deleteById(id);
    }
}
