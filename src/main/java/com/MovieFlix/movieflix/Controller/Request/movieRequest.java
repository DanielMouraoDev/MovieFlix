package com.MovieFlix.movieflix.Controller.Request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.util.List;

public record movieRequest(

        @Schema(description = "Título do filme", example = "O Senhor dos Anéis")
        @NotEmpty(message = "Titulo do filme é obrigatorio!")
        String title,

        @Schema(description = "Descrição do filme")
        String description,

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
        @Schema(type = "string", pattern = "dd/MM/yyyy", description = "Data de lançamento", example = "25/12/2023")
        LocalDate releaseDate,

        @Schema(description = "Score do filme", example = "9.5")
        double rating,

        @Schema(description = "Lista de IDs de categorias")
        List<Long> categories,

        @Schema(description = "Lista de IDs de serviços de streaming")
        List<Long> streamings
) {
}