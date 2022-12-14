package com.example.demo.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.BookService;
@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book saveBook(Book book) {
		//Story bb=book.getStory();
		//bb.setBook(book);
		return bookRepository.save(book);
	}

	@Override
	public Book findById(int id) {
		Book bb=bookRepository.findById(id).get();
		return bb;
	}

	@Override
	public String deletebybookid(int bookId) {
    bookRepository.deleteById(bookId);
    return "deleted";
	}
	
	@Override
	public Book updatebookdetails(Book book) {
	Book boo=bookRepository.findById(book.getBookId()).orElse(book);
	boo.setBookName(book.getBookName());
	boo.setStory(book.getStory());
	return bookRepository.save(book);
	}
}
