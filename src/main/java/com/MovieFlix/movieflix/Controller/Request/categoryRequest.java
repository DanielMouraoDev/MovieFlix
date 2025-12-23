package com.MovieFlix.movieflix.Controller.Request;

import jakarta.validation.constraints.NotEmpty;

public record categoryRequest(@NotEmpty(message = "Nome da categoria é obrigatorio!") String name) {
}