package com.shan.crudtestproject.entity;

public class BookServiceResponse {
	private Book book;
	private String status;
	private String statusCode;
	private String statusMessage;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "BookServiceResponse [book=" + book + ", status=" + status + ", statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + "]";
	}

}
