package com.MovieFlix.movieflix.Controller.Response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class categoryResponse {
    private Long id;
    private String name;
}