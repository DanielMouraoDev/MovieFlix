package com.MovieFlix.movieflix.Mapper;

import com.MovieFlix.movieflix.Controller.Request.userRequest;
import com.MovieFlix.movieflix.Controller.Response.userResponse;
import com.MovieFlix.movieflix.Entity.user;
import lombok.experimental.UtilityClass;

@UtilityClass
public class userMapper {

    private static user userResponse;

    public static user toUser(userRequest request){
        return user.builder()
                .name(request.name())
                .email(request.email())
                .password(request.passoword())
                .build();
    }

    public static user toUserResponse(user user) {
        return userResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build()
                .build;
    }
}
