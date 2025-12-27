package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookRepo;
import com.examly.springapp.repository.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookRepo bookRepo;
    
    @Autowired
    private BookCategoryRepo bookCategoryRepo;
    
    @Override
    public Book saveBook(Book book) {
        if (book.getBookCategory() != null && book.getBookCategory().getCategoryId() != null) {
            BookCategory category = bookCategoryRepo.findById(book.getBookCategory().getCategoryId()).orElse(null);
            book.setBookCategory(category);
        }
        return bookRepo.save(book);
    }
    
    @Override
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }
    
    @Override
    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElse(null);
    }
    
    @Override
    public Book updateBook(Long id, Book book) {
        if (book.getBookCategory() != null && book.getBookCategory().getCategoryId() != null) {
            BookCategory category = bookCategoryRepo.findById(book.getBookCategory().getCategoryId()).orElse(null);
            book.setBookCategory(category);
        }
        book.setBookId(id);
        return bookRepo.save(book);
    }
    
    @Override
    public List<Book> getBooksByCategoryName(String categoryName) {
        return bookRepo.findByBookCategoryCategoryName(categoryName);
    }
    
    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findByTitle(title);
    }
}
