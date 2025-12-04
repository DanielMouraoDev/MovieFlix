package com.MovieFlix.movieflix.Controller.Response;

import com.MovieFlix.movieflix.Entity.user;
import lombok.Builder;

@Builder
public record userResponse(Long id, String name, String email) extends user {
}
