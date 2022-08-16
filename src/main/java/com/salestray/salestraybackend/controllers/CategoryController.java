package com.salestray.salestraybackend.controllers;

import com.salestray.salestraybackend.entities.Category;
import com.salestray.salestraybackend.entities.Item;
import com.salestray.salestraybackend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping(path="/all")
    public @ResponseBody List<Category> allCategories() {
        List<Category> result = categoryRepository.findAll();
        return result;
    }

    @GetMapping(path="/findByName")
    public @ResponseBody List<Category> findByName(@RequestParam String name) {
        List<Category> result = categoryRepository.findByName(name);
        return result;
    }

    @GetMapping(path="/findByCategoryID")
    public @ResponseBody List<Item> findItemsByCategory(@RequestParam Long categoryId) {
        Category result = categoryRepository.findById(categoryId).orElse(null);
        return result.getItemList();
    }

    @PostMapping (path="/add")
    public @ResponseBody Category addCategory() {
        Category result = categoryRepository.save(null);
        return result;
    }

    @PostMapping (path="/update")
    public @ResponseBody Category updateCategory(@RequestBody Category category) {
        Category result = categoryRepository.save(category);
        return result;
    }
}
