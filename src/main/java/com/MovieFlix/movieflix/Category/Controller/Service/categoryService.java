package com.MovieFlix.movieflix.Category.Controller.Service;

import com.MovieFlix.movieflix.Category.Controller.Entity.category;
import com.MovieFlix.movieflix.Category.Controller.Repository.categoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class categoryService {

    private final categoryRepository repository;

    public categoryService(categoryRepository repository) {
        this.repository = repository;
    }

    public List<category> findAll() {
        return repository.findAll();
    }

    public Optional<category> findById(Long id) {
        return repository.findById(id);
    }

    public category saveCategory(category category) {
        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}