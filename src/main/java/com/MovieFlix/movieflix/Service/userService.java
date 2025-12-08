package com.MovieFlix.movieflix.Service;

import com.MovieFlix.movieflix.Entity.user;
import com.MovieFlix.movieflix.Repository.userRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class userService {

    private final userRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public user save(user user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return userRepository.save(user);
    }
}
