package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import org.springframework.data.domain.Page;
import java.util.List;

public interface BookCategoryService {

    BookCategory addCategory(BookCategory category);

    List<BookCategory> getAllCategories();

    BookCategory getCategoryById(Long id);

    BookCategory updateCategory(Long id, BookCategory category);

    Page<BookCategory> getCategoriesWithPagination(int pageNumber, int pageSize);
}
