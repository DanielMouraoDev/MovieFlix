package com.MovieFlix.movieflix.Controller;

import com.MovieFlix.movieflix.Controller.Request.loginRequest;
import com.MovieFlix.movieflix.Controller.Request.userRequest;
import com.MovieFlix.movieflix.Controller.Response.loginResponse;
import com.MovieFlix.movieflix.Entity.user;
import com.MovieFlix.movieflix.Mapper.userMapper;
import com.MovieFlix.movieflix.Service.userService;
import com.MovieFlix.movieflix.config.tokenService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movieflix/auth")
@RequiredArgsConstructor
public class authController {

    private final userService userService;
    private final AuthenticationManager authenticationManager;
    private final tokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<user> saveUser(@RequestBody userRequest request) {
        user newUser = userMapper.toUser(request);
        user savedUser = userService.save(newUser);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userMapper.toUserResponse(savedUser));
    }

    @PostMapping("/login")
    public ResponseEntity<loginResponse> login(@RequestBody loginRequest request) {
        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        Authentication authenticate = authenticationManager.authenticate(userAndPass);

        User user = (User) authenticate.getPrincipal();

        String token = tokenService.generateToken((user) user);

        return ResponseEntity.ok(new loginResponse(token));
    }
}