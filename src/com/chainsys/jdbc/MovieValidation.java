package com.chainsys.jdbc;

public class MovieValidation {
	public void validatemovie(int id,String name,int price) throws Exception
	{
		if(id<=0)
			
		{
			throw new Exception("Invalid id number.Please enter correct id number");
		}
		if(name==null)
		{
			throw new Exception("Invalid name and name must not be null");
		}
		if(price<=0)
		{
			throw new Exception("Invalid price .Please enter correct price value");
		}
	}

}
