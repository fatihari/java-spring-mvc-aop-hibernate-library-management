package com.fa.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fa.spring.dao.IBookDAO;
import com.fa.spring.entity.Book;
import com.fa.spring.service.IBookService;
import com.fa.spring.util.SortUtils;

@Controller
@RequestMapping("/book")
public class BookController 
{
	//	get inject the bookService
	
	/*	With the @Autowired, Spring is going to scan for a component that implements the IBookDAO interface.
	*	Thanks to the @Service notation defined above the bookService Java class that implements the IbookService interface, 
	*	it can be found, used and injected.
	*/
	@Autowired		
	private IBookService iBookService;
	
	//@RequestMapping("/list")
	@GetMapping("/list")	//By accessing the URL in the browser, the Get request is sent and the information is called. 
	public String listBooks(Model model, @RequestParam(required=false) String sort) 
	{
		/*
		//	get books from the Service (Business)
		List<Book> bookList = iBookService.listBooks(); //delegate calls to Service 
		
		//	add books to the Spring MVC model.
		model.addAttribute("bookList", bookList);	// ("modelAtt_name", modelAtt_value)
		return "list-books";
		*/
		
		// get books from the service
		List<Book> bookList = null;
		
		// check for sort field
		if (sort != null) {
			int sortColumn = Integer.parseInt(sort);
			bookList = iBookService.getBooks(sortColumn);			
		}
		else {
			// no sort field provided ... default to sorting by id
			bookList = iBookService.getBooks(SortUtils.ID);
		}
		
		// add the customers to the model
		model.addAttribute("bookList", bookList);
		
		System.out.println("return list-books view page in BookController");
		return "list-books";
	}
	
	@GetMapping("/addBook")
	public String addBook(Model model) 
	{
		//	create model att to bind form data
		Book book = new Book();
		model.addAttribute("book", book);	// !!! ("modelAtt_name", modelAtt_value) form name="book"
		
		return "add-update-book";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) 
	{
		//	save the book using the service
		this.iBookService.saveOrUpdateBook(book);
		
		return "redirect:/book/list";
	}
	
	@GetMapping("/updateBook")
	public String updateBook(@RequestParam("bookId") int id, Model model) 
	{
		//	get the book from the book service
		Book book = this.iBookService.getBook(id);
		
		//	Set the book as a model attribute to pre-populate the form. 
		model.addAttribute("book", book);
		
		//	send over to the form
		return "add-update-book";
	}
	
	@GetMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") int id) 
	{
		//	delete the book
		iBookService.deleteBook(id);
		
		return "redirect:/book/list";
	}
	
    @GetMapping("/searchBook")
    public String searchCustomers(@RequestParam("searchName") String searchName,
                                    Model theModel) {
        // search customers from the service
        List<Book> bookList = iBookService.searchBook(searchName);
                
        // add the customers to the model
        theModel.addAttribute("bookList", bookList);
        return "list-books";        
    }
	
}























