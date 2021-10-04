package com.fa.spring.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fa.spring.entity.Book;
import com.fa.spring.util.SortUtils;

@Repository	 		//	for Spring to be able to "component scan", "find this repository" and then also handle the "exception translation" for us
public class BookDAO implements IBookDAO
{

	//	1-	get inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/*@Override
	//@Transactional 		//	2-	It automatically starts and commit transactions. //move to service layer
	public List<Book> listBooks() 
	{	
		//	3-	create session
		Session session = sessionFactory.getCurrentSession();
	
		//	4-	create a query
		Query<Book> query = session.createQuery("FROM Book", Book.class); //"From Book" => it is entity(class) name that is not table name!
		
		//	5-	execute query and get result list
		List<Book> bookList = query.getResultList();
		
		//	6-	return the results
		
		return bookList;
	}
*/
	@Override
	public List<Book> getBooks(int sortColumn) 
	{
		// get the current hibernate session
				Session session = sessionFactory.getCurrentSession();
						
				// determine sort field
				String fieldName = null;
				
				switch (sortColumn) {
					case SortUtils.ID: 
						fieldName = "id";
						break;
					case SortUtils.NAME: 
						fieldName = "name";
						break;
					case SortUtils.AUTHOR:
						fieldName = "author";
						break;
					case SortUtils.LITERATURE:
						fieldName = "literature";
						break;
					case SortUtils.YEAR:
						fieldName = "year";
						break;
					default:
						// if nothing matches the default to sort by id
						fieldName = "id";
				}
				
				// create a query  
				String queryString = "from Book order by " + fieldName;
				Query<Book> query = session.createQuery(queryString, Book.class);
				
				// execute query and get result list
				List<Book> bookList = query.getResultList();
						
				// return the results		
				return bookList;
	}
	

	@Override
	public void saveOrUpdateBook(Book book) //save or update
	{
		//	get current session
		Session session = sessionFactory.getCurrentSession();
		
		//	save or update the book...
		session.saveOrUpdate(book);	
	}


	@Override
	public Book getBook(int id) {
		//	get current session
		Session session = sessionFactory.getCurrentSession();
		
		//	get book from db using pk
		Book book = session.get(Book.class, id);
		
		return book;
	}


	@Override
	public void deleteBook(int id) 
	{
		//	get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//	delete book with primary key
		Query query = session.createQuery("DELETE FROM Book WHERE id=:bookId");
		query.setParameter("bookId", id);
		query.executeUpdate();	
	}


	@Override
	public List<Book> searchBook(String searchName) {
		
//		get current hibernate session
		Session session = sessionFactory.getCurrentSession();
        Query query = null;
        
        //
        // if searchName is not empty
        //
        if (searchName != null && searchName.trim().length() > 0) {
            // search for book name ... case insensitive
        	query =session.createQuery("from Book where lower(name) like :searchName", Book.class);
            query.setParameter("searchName", "%" + searchName.toLowerCase() + "%");
        }
        else {
            // if SearchName is empty, get all customers
        	query = session.createQuery("from Book", Book.class);            
        }
        
        // execute query and get result list
        List<Book> bookList = query.getResultList();
                
        // return the results        
        return bookList;
	}




}
