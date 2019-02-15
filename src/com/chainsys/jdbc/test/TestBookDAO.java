package com.chainsys.jdbc.test;

import java.util.Scanner;

import com.chainsys.jdbc.BookDAO;
import com.chainsys.jdbc.BookValidator;

public class TestBookDAO {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		BookDAO bookDAO = new BookDAO();
		BookValidator validator = new BookValidator();
		System.out.println("Enter the number what to be serached");
		System.out.println("\n1.insert\n2.update\n3.delete\n4.print");
		int number = scanner.nextInt();
		switch (number) {
		case 1:
			System.out.println("Ënter id ,name ,price to add");
			int id = scanner.nextInt();
			String name = scanner.next();
			int price = scanner.nextInt();
			try {

				validator.validateBook(id, name, price);
				bookDAO.addBook(id, name, price);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bookDAO.findAll();
			break;
		case 2:
			System.out.println("Enter the name  and idnumber to be updtaed");
			String name1 = scanner.next();
			int idno = scanner.nextInt();
			bookDAO.updateBook(name1, idno);
			bookDAO.findAll();
			break;
		case 3:
			System.out.println("Enter bookno to be deleted");
			int id1 = scanner.nextInt();
			bookDAO.deleteBook(id1);
			bookDAO.findAll();
			break;
		case 4:
			bookDAO.findAll();
			break;
		default:
			System.out.println("Please enter te correct value");
		}

		scanner.close();

	}

}
