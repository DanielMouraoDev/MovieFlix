package com.MovieFlix.movieflix.Controller.Response;

import lombok.Builder;

@Builder
public record streamingResponse(Long id, String name) {
}
