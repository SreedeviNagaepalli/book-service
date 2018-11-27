package com.spring.book.service.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.book.service.example.request.BookDetail;
import com.spring.book.service.example.service.BookService;

@RestController
@Configuration
@RequestMapping("/books")
public class BookController {

	@Autowired
	BookService bookService;

	@RequestMapping(method = RequestMethod.GET, value = "/getAllBooks", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<BookDetail> getAllBooks() {

		return bookService.getAllBooks();

	}

	@RequestMapping(method = RequestMethod.POST, value = "/addBook", produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<BookDetail> addBook(@RequestBody BookDetail bookDetail) {

		List<BookDetail> list = new ArrayList<BookDetail>();

		if (null != bookDetail) {
			return bookService.addBook(bookDetail);
		}

		return list;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getBooksByAuthor", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<BookDetail> getAllBooksByAuthor(@RequestParam String author) {
		List<BookDetail> authBookList = new ArrayList<BookDetail>();
		if (null != author) {
			List<BookDetail> allBooksList = bookService.getAllBooks();

			if (!CollectionUtils.isEmpty(allBooksList) && allBooksList.size() > 0) {
				for (BookDetail book : allBooksList) {
					if (book.getAuthor().equals(author)) {
						authBookList.add(book);
					}
				}
			}
		}

		return authBookList;

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getBooksByTitle", produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public List<BookDetail> getBooksByTitle(@RequestParam String bookTitle) {
		List<BookDetail> authBookList = new ArrayList<BookDetail>();

		if (null != bookTitle) {
			List<BookDetail> allBooksList = bookService.getAllBooks();

			if (!CollectionUtils.isEmpty(allBooksList) && allBooksList.size() > 0) {
				for (BookDetail book : allBooksList) {

					if (Pattern.matches(bookTitle, book.getBookTitle())) {
						authBookList.add(book);
					}
				}
			}
		}

		return authBookList;
	}

}
