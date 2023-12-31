package com.example.library;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //consider a book class as a table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    private String bookName;
    private String author;
    private int quantity;
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

   
}