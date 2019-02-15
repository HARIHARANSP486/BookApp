package com.chainsys.jdbc.test;

import java.util.Scanner;

import com.chainsys.jdbc.BookValidator;
import com.chainsys.jdbc.MovieDAO;

public class TestMovieDAO {
	public static void main(String[] args) throws Exception {
		Scanner scanner=new Scanner(System.in);
		MovieDAO movieDAO = new MovieDAO();
		BookValidator movievalidator=new BookValidator();
		System.out.println("Enter the number what to be activated");
		System.out.println("1.insert\n2.upate\n3.delete\n4.printall\n5.printbyid\n6.order");
		int number=scanner.nextInt();
		switch(number)
		{
		case 1:
			System.out.println("Enter the id,name,price to be added");
			int id=scanner.nextInt();
			String name=scanner.next();
			int price=scanner.nextInt();
			try {
				movievalidator.validateBook(id,name,price);
				movieDAO.addMovie(id,name,price);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			movieDAO.displayMovie();
			break;
			
		case 2:
			System.out.println("update process");
			System.out.println("Enter the id to change the movie name");
			String name1=scanner.next();
			int idno=scanner.nextInt();
			movieDAO.updateMovie(name1,idno);
			movieDAO.displayMovie();
			break;
		case 3:
			System.out.println("delete process");
			System.out.println("Enter the movie name to be deleted");
			String name2=scanner.next();
			movieDAO.deleteMovie(name2);
			movieDAO.displayMovie();
			break;
		case 4:
			System.out.println("Print the function");
			movieDAO.displayMovie();
			break;
		case 5:
			System.out.println("ENter the id to be displayed");
			int idsearch=scanner.nextInt();
			movieDAO.displayMoviebyid(idsearch);
			movieDAO.displayMovie();
			break;
		case 6:
			
			movieDAO.orderById();
			movieDAO.displayMovie();
			break;
			default:
				System.out.println("PLease enter the correct value");
			
		}
		
	}

}
