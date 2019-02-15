package com.chainsys.jdbc.test; 

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import com.chainsys.jdbc.BookValidation;
import com.chainsys.jdbc.Books;
import com.chainsys.jdbc.BooksDAO;

public class TestBook {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Books books = new Books();
		Scanner scanner = new Scanner(System.in);
		BooksDAO booksDAO = new BooksDAO();
		BookValidation validation = new BookValidation();
		System.out.println("1.insertion\n2.finebyid\n3.printall\n4.update\n5.delete");
		System.out.println("Enter the number what to be searched");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("Ënter id ,name ,price,date to add");
			int id = scanner.nextInt();
			String name = scanner.next();
			int price = scanner.nextInt();
			String date=scanner.next();
			books.id = id;
			books.name = name;
			books.price = price;
			books.publishingDate=LocalDate.parse(date);
		
			try {
				validation.validateAdd(books);
				booksDAO.addBook(books);

			} catch (Exception e)

			{
				e.printStackTrace();
			}
			booksDAO.findAll(books);
			break;
		case 2:
			System.out.println("Enter the idnumber to be searched");
			int idnumber = scanner.nextInt();
			books.id = idnumber;
			validation.validateFindbyid(books);
			Books books1 = booksDAO.findbyId(books);
			if (books1 != null) {
				System.out.println(books1.id);
				System.out.println(books1.name);
				System.out.println(books1.price);
			}
			else
			{
				System.out.println("No records found");
			}
			booksDAO.findAll(books);  
			break;
		case 3:
			System.out.println("Details to be printd");
			ArrayList<Books> list=booksDAO.findAll(books);
			if(list.size()==0)
			{
				System.out.println("empty");
			}
			else
			{
				for(Books b:list)
				{
					System.out.println(b.id+"  "+b.name+"  "+b.price);
				}
			}
			break;
		case 4:
			System.out.println("Update process");
			System.out.println("ENter the name and  id number to be updtaed");
			books.name=scanner.next();
			books.id=scanner.nextInt();
			try {
				validation.validateUpdate(books);
				booksDAO.updateBook(books);
				//booksDAO.findAll(books);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			booksDAO.findAll(books);
			break;
		case 5:
			System.out.println("DElete procss");
			System.out.println("Enter the id number to be deleted");
			books.id=scanner.nextInt();
			try {
				validation.validateDelete(books);
				booksDAO.deleteBook(books);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			booksDAO.findAll(books);
			break;
		}

	}
}
