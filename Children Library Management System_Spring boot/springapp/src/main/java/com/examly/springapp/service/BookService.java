package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import java.util.List;

public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book updateBook(Long id, Book book);
    List<Book> getBooksByCategoryName(String categoryName);
    List<Book> getBooksByTitle(String title);
}
