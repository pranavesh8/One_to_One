package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
@Service
public interface BookService {

	Book saveBook(Book book);

	Book findById(int bookId);

	String deletebybookid(int bookId);

	Book updatebookdetails(Book book);

}
