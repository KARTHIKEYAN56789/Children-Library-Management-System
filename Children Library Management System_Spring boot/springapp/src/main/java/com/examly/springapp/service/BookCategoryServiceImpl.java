package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    @Override
    public BookCategory addCategory(BookCategory category) {
        return bookCategoryRepo.save(category);
    }

    @Override
    public List<BookCategory> getAllCategories() {
        return bookCategoryRepo.findAll();
    }

    @Override
    public BookCategory getCategoryById(Long id) {
        return bookCategoryRepo.findById(id).orElse(null);
    }

    @Override
    public BookCategory updateCategory(Long id, BookCategory category) {
        if (bookCategoryRepo.existsById(id)) {
            category.setCategoryId(id);
            return bookCategoryRepo.save(category);
        }
        return null;
    }

    @Override
    public Page<BookCategory> getCategoriesWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return bookCategoryRepo.findAll(pageable);
    }
}
