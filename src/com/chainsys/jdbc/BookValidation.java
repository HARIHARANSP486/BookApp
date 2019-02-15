package com.chainsys.jdbc;

//import java.awt.print.Books;

public class BookValidation {
	public void validateAdd(Books books) throws Exception
	{
		if(books.name==null)
		{
			throw new Exception("invalid name");
		}
		if(books.price<=0)
		{
			throw new Exception("Invalid price! price cannot be less than 0");
		}
	}
	public void validateUpdate(Books books) throws Exception
	{
		if(books.name==null)
		{
			throw new Exception("Invalaid name");
		}
		if(books.id<=0)
		{
				throw new Exception("Invalid id");
		}
		
	}
	public void validateDelete(Books books) throws Exception
	
	{
		if(books.id<=0)
		{
			throw new Exception("Invalid id number");
		}
	}
	public void validateFindbyid(Books books) throws Exception
	{
		if(books.id<=0)
		{
			throw new Exception("Invalid id number");
		}
	}

}
