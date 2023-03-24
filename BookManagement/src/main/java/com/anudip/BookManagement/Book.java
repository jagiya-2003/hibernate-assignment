package com.anudip.BookManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)//id is auto incremented
	int book_id;
	String book_name;
	int book_price;
	String author_name;
	final static String library_name="Central City Library";//only one library
	String Availability;
	public Book() 
	{}
	public Book(String book_name, int book_price, String author_name,String Availability) 
	{
		
		this.book_name = book_name;
		this.book_price = book_price;
		this.author_name = author_name;
		this.Availability=Availability;
	}
	public String getAvailability() 
	{
		return Availability;
	}
	public void setAvailability(String availability) 
	{
		Availability = availability;
	}
	public int getBook_id() 
	{
		return book_id;
	}
	public void setBook_id(int book_id)
	{
		this.book_id = book_id;
	}
	public String getBook_name()
	{
		return book_name;
	}
	public void setBook_name(String book_name)
	{
		this.book_name = book_name;
	}
	public int getBook_price() 
	{
		return book_price;
	}
	public void setBook_price(int book_price) 
	{
		this.book_price = book_price;
	}
	public String getAuthor_name() 
	{
		return author_name;
	}
	public void setAuthor_name(String author_name) 
	{
		this.author_name = author_name;
	}
	public static String getLibrary_name() 
	{
		return library_name;
	}
	
	
}