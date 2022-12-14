package com.example.demo.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//@Entity annotation defines that said class is an entity and will be mapped to a database table
@Entity   
//@Table annotation defines the name of the database table to be used for mapping
@Table(name="book")    
public class Book {
	
	 //@Id annotation defines the primary key of an entity.
	 @Id            
	 /*
	 * @GeneratedValue annotation is used to specify the primary key generation
	 * strategy to use. If the strategy is not specified by default AUTO will be
	 * used.If we want to automatically generate the primary key value, we can add
	 * the @GeneratedValue annotation. This can use four generation types: AUTO,
	 * IDENTITY, SEQUENCE and TABLE.
	 */	
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int bookId;
    //@Column annotation is used for Adding the column the name in the table of a particular MySQL database.
	@Column(name = "book_name")
    private String bookName;
	//@OneToOne JPA annotation is used to map the source entity with the targetentity
	//casecade:=When we perform some action on the target entity, the same action will be applied to the associated entity.
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "book")
	@JsonManagedReference                                                      

    private Story story;
   
	
	/*
	 * Getters and setters are used to protect your data, particularly when creating
	 * classes. For each instance variable, a getter method returns its value while
	 * a setter method sets or updates its value.
	 */

	public int getBookId() {
		return bookId;
	}


	public void setBookId(int bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public Story getStory() {
		return story;
	}


	public void setStory(Story story) {
		this.story = story;
	}
	
	
}
