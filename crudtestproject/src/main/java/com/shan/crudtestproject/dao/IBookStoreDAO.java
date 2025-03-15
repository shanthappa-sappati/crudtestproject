package com.shan.crudtestproject.dao;

import java.util.List;

import com.shan.crudtestproject.entity.Book;

public interface IBookStoreDAO {

	List<Book> getBooks();

	Book getBook(int bookId);

	Book createBook(Book book);

	Book updateBook(int bookId, Book book);

	boolean deleteBook(int bookId);

}
