package com.example.bootemo.service;

import com.example.bootemo.model.Category;

public interface CategoryService {

    Iterable<Category> findAll();

    Category findById(Long id);
}
