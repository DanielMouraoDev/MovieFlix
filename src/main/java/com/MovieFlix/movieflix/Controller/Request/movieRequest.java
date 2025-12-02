package com.MovieFlix.movieflix.Controller.Request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record movieRequest(String title,
                           String description,

                           @JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/YY")
                           LocalDate releasedate,

                           double rating,
                           List<Long> categories,
                           List<Long> streamings) {

}
