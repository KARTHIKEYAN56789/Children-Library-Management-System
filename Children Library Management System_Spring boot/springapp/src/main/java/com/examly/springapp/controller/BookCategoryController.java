package com.examly.springapp.controller;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @PostMapping
    public ResponseEntity<BookCategory> createCategory(
            @RequestBody(required = false) BookCategory category) {

        if (category == null) {
            return ResponseEntity.badRequest().build();
        }
        BookCategory savedCategory = bookCategoryService.addCategory(category);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllCategories() {
        List<BookCategory> categories = bookCategoryService.getAllCategories();
        if (categories.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        BookCategory category = bookCategoryService.getCategoryById(id);
        if (category == null) {
            return new ResponseEntity<>("Book category not found.", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateCategory(
            @PathVariable Long id,
            @RequestBody BookCategory category) {
        BookCategory updatedCategory = bookCategoryService.updateCategory(id, category);
        if (updatedCategory == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<BookCategory>> getCategoriesWithPagination(
            @PathVariable int pageNumber,
            @PathVariable int pageSize) {
        Page<BookCategory> page = bookCategoryService.getCategoriesWithPagination(pageNumber, pageSize);
        return ResponseEntity.ok(page);
    }
}
