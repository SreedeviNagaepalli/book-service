package com.spring.book.service.example.service;

import java.util.List;

import com.spring.book.service.example.request.BookDetail;

public interface BookService {

	List<BookDetail> getAllBooks();

	List<BookDetail> addBook(BookDetail book);

}
