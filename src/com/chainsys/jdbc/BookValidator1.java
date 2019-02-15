package com.chainsys.jdbc;

public class BookValidator1 {
	public void validateBook(Books books) throws Exception
	{
		if(books.id<=0)
			
		{
			throw new Exception("Invalid id number.Please enter correct id number");
		}
		if(books.name==null)
		{
			throw new Exception("Invalid name and name must not be null");
		}
		if(books.price<=0)
		{
			throw new Exception("Invalid price .Please enter correct price value");
		}
	}


}
