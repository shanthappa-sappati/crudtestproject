package com.shan.crudtestproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shan.crudtestproject.entity.Book;
import com.shan.crudtestproject.entity.BookServiceResponse;
import com.shan.crudtestproject.service.IBookStoreService;

@Controller
@RequestMapping("bookservice")
public class BookStoreController {

	@Autowired
	private IBookStoreService service;

	@GetMapping("books")
	public ResponseEntity<List<Book>> getBooks() {

		List<Book> books = service.getBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}

	@GetMapping("books/{id}")
	public ResponseEntity<BookServiceResponse> getBook(@PathVariable("id") Integer id) {
		BookServiceResponse response = new BookServiceResponse();
		Book book = service.getBook(id);
		if(book==null) {
			response.setStatus("Not Found");
			response.setStatusCode("404");
			response.setStatusMessage("Requested Id not Found");
			return new ResponseEntity<BookServiceResponse>(response, HttpStatus.NOT_FOUND);
		}else {
			response.setStatus("Success");
			response.setStatusCode("200");
			response.setStatusMessage("Book is available");
			response.setBook(book);
		}
		return new ResponseEntity<BookServiceResponse>(response, HttpStatus.OK);
	}

	@PostMapping("books")
	public ResponseEntity<BookServiceResponse> createBook(@RequestBody Book book) {
		BookServiceResponse response = new BookServiceResponse();
		Book b = service.createBook(book);
		response.setStatus("Success");
		response.setStatusCode("200");
		response.setStatusMessage("Book create Successfully");
		response.setBook(b);
		return new ResponseEntity<BookServiceResponse>(response, HttpStatus.OK);

	}

	@PutMapping("books/{id}")
	public ResponseEntity<BookServiceResponse> updateBook(@PathVariable("id") int id, @RequestBody Book book) {

		BookServiceResponse response = new BookServiceResponse();
		Book b = service.createBook(book);
		response.setStatus("Success");
		response.setStatusCode("200");
		response.setStatusMessage("Book create Successfully");
		response.setBook(b);
		return new ResponseEntity<BookServiceResponse>(response, HttpStatus.OK);
	}

	@PatchMapping("books/{id}")
	public ResponseEntity<Book> patchBook(@PathVariable("id") int id, @RequestBody Book book) {

		Book b = service.updateBook(id, book);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}

	@DeleteMapping("books/{id}")
	public ResponseEntity<BookServiceResponse> deleteBook(@PathVariable("id") int id) {
		BookServiceResponse response = new BookServiceResponse();

		boolean isDeleted = service.deleteBook(id);

		if (isDeleted) {
			response.setStatus("Success");
			response.setStatusCode("200");
			response.setStatusMessage("Book has been deleted successfully");
			return new ResponseEntity<BookServiceResponse>(response, HttpStatus.OK);
		}
		response.setStatusMessage("Error while deleting book from database");
		return new ResponseEntity<BookServiceResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
