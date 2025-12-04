package com.MovieFlix.movieflix.Service;

import com.MovieFlix.movieflix.Entity.user;
import com.MovieFlix.movieflix.Repository.userRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userService {

    private final userRepository userRepository;

    public user save(user user) {
        return userRepository.save(user);
    }
}
