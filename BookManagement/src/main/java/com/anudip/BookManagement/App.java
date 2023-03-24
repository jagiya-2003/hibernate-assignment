package com.anudip.BookManagement;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
	public static SessionFactory getConfiguration() 
	{
		
		Configuration conf = new Configuration().configure().addAnnotatedClass(Book.class);
		SessionFactory ss = conf.buildSessionFactory();
		return ss;
	}
	public static void create_book(Session ss,Transaction t) 
	{
		Book b1 = new Book("Book1",800,"D. morgan","Available");
		Book b2 = new Book("Book2",300,"King pirates","Available");
		Book b3 = new Book("Book3",750,"A.K Shaha","Available");
		Book b4 = new Book("Book4",1000,"Sonali Sambare","Not Available");
		Book b5 = new Book("Book5",900,"Sandeep Kamble","Not Available");
		
		ss.save(b1);
		ss.save(b2);
		ss.save(b3);
		ss.save(b4);
		ss.save(b5);
		t.commit();
	}
		
	public static void getbooks(Session ss,Transaction t)
	{
		Query query = ss.createQuery("from Book");
		List<Book> books = query.list();
		for(Book getbooks:books) {
			System.out.println("Book id: "+getbooks.getBook_id()+" Book Name: "+getbooks.getBook_name()+" Book price: "+getbooks.getBook_price()+" Author Name: "+getbooks.getAuthor_name()+" Library Name: "+getbooks.getLibrary_name()+" Availability: "+getbooks.getAvailability());
		}
	}
	public static void updatebooks(Session ss,Transaction t) 
	{
		t.begin();
		Book updatebook =ss.find(Book.class,1);
		updatebook.setBook_name("Wings Of Fire");
		ss.save(updatebook);
		t.commit();
	}
	public static void deletebook(Session ss, Transaction t) 
	{
		t.begin();
		Book deletebook =ss.find(Book.class, 2);
		ss.delete(deletebook);
		t.commit();
	}
    public static void main( String[] args )
    {
        SessionFactory sf =getConfiguration();
        Session ss =sf.openSession();
        Transaction t =ss.beginTransaction();
        
        create_book(ss, t);
        updatebooks(ss, t);
        deletebook(ss, t);
        getbooks(ss, t);
        System.out.println(" OK ");
    }
}