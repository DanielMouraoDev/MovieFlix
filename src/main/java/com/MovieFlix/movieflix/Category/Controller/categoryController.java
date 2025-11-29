package com.MovieFlix.movieflix.Category.Controller;

import com.MovieFlix.movieflix.Category.Controller.Request.categoryRequest;
import com.MovieFlix.movieflix.Category.Controller.Response.categoryResponse;
import com.MovieFlix.movieflix.Category.Controller.Entity.category;
import com.MovieFlix.movieflix.Category.Controller.Mapper.categoryMapper;
import com.MovieFlix.movieflix.Category.Controller.Service.categoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
@RequiredArgsConstructor
public class categoryController {

    private final categoryService categoryService;

    @GetMapping()
    public ResponseEntity<List<categoryResponse>> getAllCategories() {
        List<categoryResponse> categories = categoryService.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);
    }

    @PostMapping
    public ResponseEntity<categoryResponse> saveCategory(@RequestBody categoryRequest request) {
        category newCategory = categoryMapper.toCategory(request);
        category savedCategory = categoryService.saveCategory(newCategory);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryMapper.toCategoryResponse(savedCategory));
    }

    @GetMapping("/{id}")
    public ResponseEntity<categoryResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(categoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}