package com.MovieFlix.movieflix.Controller.Request;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record streamingRequest(@NotEmpty(message = "Nome do Streaming é obrigatorio!") String name) {
}

