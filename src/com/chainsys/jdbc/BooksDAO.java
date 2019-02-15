package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BooksDAO {
	public void addBook(Books books) throws Exception 
	{
		/*
		 * pre condition id,name,price must be valid
		 */
		try {
			Connection connection=ConnectionUtil.getConnection(); 
			String sql="insert into books(bookno,bookname,bookprice,publishingdate) values(?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, books.id);
			preparedStatement.setString(2, books.name);
			preparedStatement.setInt(3,books.price);
			//coming line is used to convert local date into sql date
			preparedStatement.setDate(4,Date.valueOf(books.publishingDate));
			
			int rows=preparedStatement.executeUpdate();
			System.out.println("Rows qffected: "+rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 throw new Exception("Unable to insert books");
			
		}}
	public Books findbyId(Books books) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="select bookno,bookname,bookprice,publishingDate,publishedDate from books where bookno=?";
		System.out.println(sql);
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, books.id);
			   
			 ResultSet rset=preparedStatement.executeQuery();
			 Books bookdetails=null;
			 if(rset.next())
			 {
				bookdetails=new Books();
				bookdetails.id=rset.getInt("bookno");
				bookdetails.name=rset.getString("bookname");
				bookdetails.price=rset.getInt("bookprice");
				//coming line is used to convert sql date to local date
				bookdetails.publishingDate=rset.getDate("publishingDate").toLocalDate();
			 }
			 return bookdetails;
				
		
	}
	public ArrayList<Books> findAll(Books books) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="select bookno,bookname,bookprice from books";
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 ResultSet resultSet=preparedStatement.executeQuery();
		ArrayList<Books> booklist=new ArrayList<>();
		while(resultSet.next())
		{
			Books books1=new Books();
			books1.id=resultSet.getInt("bookno");
			books1.name=resultSet.getString("bookname");
			books1.price=resultSet.getInt("bookprice");
			booklist.add(books1);
		}
		return booklist;
		
	}
	public void updateBook(Books books) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="update books set bookname=? where bookno=?";
		System.out.println(sql);
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 preparedStatement.setString(1, books.name);
		preparedStatement.setInt(2, books.id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
		
	}
	public void deleteBook(Books books) throws SQLException
	{
		Connection connection=  ConnectionUtil.getConnection();
		String sql="delete from books where bookno=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, books.id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
	}
	
		
}
