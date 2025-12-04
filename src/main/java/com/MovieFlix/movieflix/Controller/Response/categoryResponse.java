package com.MovieFlix.movieflix.Controller.Response;

import lombok.Builder;

@Builder
public record categoryResponse(Long id, String name) {
}