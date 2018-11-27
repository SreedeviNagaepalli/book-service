package com.spring.book.service.example.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"bookId",
"bookTitle",
"bookDescription",
"author"
})
public class BookDetail {
	
	@JsonProperty("bookId")
	private String bookId;
	@JsonProperty("bookTitle")
	private String bookTitle;
	@JsonProperty("bookDescription")
	private String bookDescription;
	@JsonProperty("author")
	private String author;		
	
	public BookDetail()
	{
		super();
	}
	
	public BookDetail(String bookId, String bookTitle, String bookDescription, String author) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookDescription = bookDescription;
		this.author = author;
	}

	@JsonProperty("bookId")
	public String getBookId() {
	return bookId;
	}
	
	@JsonProperty("bookId")
	public void setBookId(String bookId) {
	this.bookId = bookId;
	}
	
	@JsonProperty("bookTitle")
	public String getBookTitle() {
	return bookTitle;
	}
	
	@JsonProperty("bookTitle")
	public void setBookTitle(String bookTitle) {
	this.bookTitle = bookTitle;
	}
	
	@JsonProperty("bookDescription")
	public String getBookDescription() {
	return bookDescription;
	}
	
	@JsonProperty("bookDescription")
	public void setBookDescription(String bookDescription) {
	this.bookDescription = bookDescription;
	}
	
	@JsonProperty("author")
	public String getAuthor() {
	return author;
	}
	
	@JsonProperty("author")
	public void setAuthor(String author) {
	this.author = author;
	}
	
}
