package com.MovieFlix.movieflix.Controller.Response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record movieResponse(Long id,
                            String title,
                            String description,

                            @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YY")
                            LocalDate releaseDate,

                            double rating,
                            List<categoryResponse> categories,
                            List<streamingResponse> streamings) {

}
