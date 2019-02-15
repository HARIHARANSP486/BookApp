package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {
	//Connection connection=null;
	//PreparedStatement preparedStatement=null;
	//ResultSet resultSet = null;
	
	public void addBook(int id,String name,int price) throws Exception 
	{
		/*
		 * pre condition id,name,price must be valid
		 */
		try {
			Connection connection=ConnectionUtil.getConnection(); 
			String sql="insert into books(bookno,bookname,bookprice) values(?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setInt(3,price);
			int rows=preparedStatement.executeUpdate();
			System.out.println("Rows qffected: "+rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 throw new Exception("Unable to insert book");
			
		}
		
		
	}
	public void updateBook(String name,int id) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="update books set bookname=? where bookno=?";
		System.out.println(sql);
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
		
	}

	public void deleteBook(int id) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="delete from books where bookno=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
	}
	public void findAll() throws SQLException
	{
	Connection connection=ConnectionUtil.getConnection();
		 String sql="select bookno,bookname,bookprice from books";
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 ResultSet resultSet=preparedStatement.executeQuery();
		 while(resultSet.next())
		 {
			 System.out.println();
			 System.out.print(resultSet.getInt("bookno")+" "+resultSet.getString("bookname")+" "+resultSet.getInt("bookprice"));
			 
		 }
		 ConnectionUtil.close(connection,preparedStatement,resultSet);
	}

	public void findById(int id) throws SQLException	{
		Connection connection=ConnectionUtil.getConnection();
		 String sql="select bookno,bookname,bookprice from books where bookno=?";
		  PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 preparedStatement.setInt(1, id);
		 ResultSet rset=preparedStatement.executeQuery();
		 if(rset.next())
		 {
			 System.out.println();
			 System.out.println(rset.getInt("bookno"));
			 System.out.println(rset.getInt("bookname"));
			 System.out.println(rset.getInt("bookprice"));
		 }
	}



}
