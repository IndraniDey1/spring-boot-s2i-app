package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.IBookStoreDAO;
import com.example.entity.Book;

@Service
public class BookStoreService   implements IBookStoreService{

	@Autowired
	private IBookStoreDAO dao;

	public List<Book> getBooks() {
		return dao.getBooks();
	}

	public Book createBook(Book book) {
		return dao.createBook(book);
	}

	public Book updateBook(int bookId, Book book) {
		return dao.updateBook(bookId, book);
	}

	public Book getBook(int bookId) {
		return dao.getBook(bookId);
	}

	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}
}