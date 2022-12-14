package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
@RestController
public class Bookcontroller {
	
	 @Autowired
	 private BookService bookService;
	
	 @RequestMapping(value = "/savebook", method = RequestMethod.POST)
     //@ResponseBody
     public Book saveBook(@RequestBody Book book) {
        Book bookResponse = bookService.saveBook(book);
        return bookResponse;
    }
	
	@RequestMapping(value = "/get/{bookId}", method = RequestMethod.GET)
	//ResponseBody
	public Book getbookdetails(@PathVariable int bookId) {
		Book book=bookService.findById(bookId);
		return book;
	}
	
	@RequestMapping(value = "/delete/{bookId}", method = RequestMethod.DELETE)
	public String deleteBookDetails(@PathVariable int bookId){
		String book=bookService.deletebybookid(bookId);
		return book;
	}

	@RequestMapping(value = "/get/{bookId}", method = RequestMethod.PUT)
	//ResponseBody
	public Book getbookdetails(@RequestBody Book book) {
		Book boo=bookService.updatebookdetails(book);
		return boo;
	}
}
