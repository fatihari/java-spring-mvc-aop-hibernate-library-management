package com.fa.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fa.spring.dao.IBookDAO;
import com.fa.spring.entity.Book;

@Service	//	for Spring to be able to "component scan", "find this service" and then also handle the "exception translation" for us
public class BookService implements IBookService 
{
	//	get inject ibookDAO
	@Autowired
	private IBookDAO iBookDAO;

	/*@Override
	@Transactional
	public List<Book> listBooks() {
		return iBookDAO.listBooks();	//	Delagate calls to DAO.
	}*/
	
	@Override
	@Transactional
	public List<Book> getBooks(int sortColumn) {
		return this.iBookDAO.getBooks(sortColumn);
	}

	@Override
	@Transactional
	public void saveOrUpdateBook(Book book) {
		this.iBookDAO.saveOrUpdateBook(book);
	}

	@Override
	@Transactional
	public Book getBook(int id) {
		return this.iBookDAO.getBook(id);
	}

	@Override
	@Transactional
	public void deleteBook(int id) 
	{
		this.iBookDAO.deleteBook(id);	
	}

	@Override
	@Transactional
	public List<Book> searchBook(String searchName) {
		
		return this.iBookDAO.searchBook(searchName);
	}



}
