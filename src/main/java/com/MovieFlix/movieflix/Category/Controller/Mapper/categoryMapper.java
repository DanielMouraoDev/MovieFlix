package com.MovieFlix.movieflix.Category.Controller.Mapper;

import com.MovieFlix.movieflix.Category.Controller.Request.categoryRequest;
import com.MovieFlix.movieflix.Category.Controller.Response.categoryResponse;
import com.MovieFlix.movieflix.Category.Controller.Entity.category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class categoryMapper {

    public static category toCategory(categoryRequest categoryRequest) {
        return category
                .builder()
                .name(categoryRequest.getName())
                .build();
    }

    public static categoryResponse toCategoryResponse(category category) {
        return categoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}