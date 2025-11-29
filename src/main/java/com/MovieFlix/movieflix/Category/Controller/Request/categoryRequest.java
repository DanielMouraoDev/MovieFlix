package com.MovieFlix.movieflix.Category.Controller.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Gera Getters (getName), Setters, toString, etc.
@AllArgsConstructor
@NoArgsConstructor
public class categoryRequest {
    private String name;
}
