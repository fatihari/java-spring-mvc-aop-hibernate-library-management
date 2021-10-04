package com.fa.spring.dao;

import java.util.List;

import com.fa.spring.entity.Book;

public interface IBookDAO 
{
	//public List<Book> listBooks();

	public void saveOrUpdateBook(Book book);

	public Book getBook(int id);

	public void deleteBook(int id);

	public List<Book> searchBook(String searchName);

	public List<Book> getBooks(int sortColumn);
}
