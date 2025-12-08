package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.loginRequest;
import com.MovieFlix.movieflix.Controller.Request.userRequest;
import com.MovieFlix.movieflix.Entity.user;
import com.MovieFlix.movieflix.Mapper.userMapper;
import com.MovieFlix.movieflix.Service.userService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class authController {

    private final userService userService;

    @PostMapping("/register") 
    public ResponseEntity<user> saveUser(@RequestBody userRequest request) {
        user savedUser = userService.save(userMapper.toUser(request));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginRequest request) {

}