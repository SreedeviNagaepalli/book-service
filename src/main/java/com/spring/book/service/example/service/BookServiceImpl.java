package com.spring.book.service.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.book.service.example.request.BookDetail;

@Service
public class BookServiceImpl implements BookService {

	@Override
	public List<BookDetail> getAllBooks() {
		List<BookDetail> bookDetaiList = new ArrayList<BookDetail>();
		try {

			BookDetail booksDetail1 = new BookDetail("1", "Java", "Java Complete Ref", "Kelly");
			BookDetail booksDetail2 = new BookDetail("2", "J2EE", "J2EE Complete Ref", "John");
			BookDetail booksDetail3 = new BookDetail("3", "Oracle", "Oracle Ref", "Kathy");
			BookDetail booksDetail4 = new BookDetail("4", "Unix", "Unix Begginners", "HeadFirst");

			bookDetaiList.add(booksDetail1);
			bookDetaiList.add(booksDetail2);
			bookDetaiList.add(booksDetail3);
			bookDetaiList.add(booksDetail4);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bookDetaiList;
	}

	@Override
	public List<BookDetail> addBook(BookDetail book) {
		List<BookDetail> bookList = getAllBooks();

		if (null != book.getBookId() && null != book.getBookTitle() && null != book.getAuthor()) {
			bookList.add(book);
			return bookList;
		}

		return bookList;
	}

}
