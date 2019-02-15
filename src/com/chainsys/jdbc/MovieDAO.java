package com.chainsys.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {
	public void addMovie(int id,String name,int price) 
	{
		try {
			Connection connection=ConnectionUtil.getConnection();
			String sql="insert into movies(id,name,price) values (?,?,?)";
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2,name);
			preparedStatement.setInt(3,price);
			int rows=preparedStatement.executeUpdate();
			System.out.println("Rows qffected: "+rows);
			ConnectionUtil.close(connection,preparedStatement,null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateMovie(String name,int id) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="update movies set name=? where id=?";
		System.out.println(sql);
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		preparedStatement.setInt(2, id);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
	}
	public void deleteMovie(String name) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="delete from movies where name=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1, name);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected: "+rows);
		ConnectionUtil.close(connection,preparedStatement,null);
	}
	public void displayMovie() throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,name,price from movies";
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 ResultSet resultSet=preparedStatement.executeQuery();
		 while(resultSet.next())
		 {
			 System.out.println();
			 System.out.print(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+resultSet.getInt("price"));
			 
		 }
		 ConnectionUtil.close(connection,preparedStatement,resultSet);
	}
	public void displayMoviebyid(int id) throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,name,price from movies where id=?";
		 PreparedStatement preparedStatement=connection.prepareStatement(sql);
		 preparedStatement.setInt(1, id);
		 ResultSet resultSet=preparedStatement.executeQuery();
		 if(resultSet.next())
		 {
			 System.out.println();
			 System.out.print(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+resultSet.getInt("price"));
			 
		 }
		 ConnectionUtil.close(connection,preparedStatement,resultSet);
	}
	public void orderById() throws SQLException
	{
		Connection connection=ConnectionUtil.getConnection();
		String sql="select id,name,price from movies order by id";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		int rows=preparedStatement.executeUpdate();
		System.out.println("Rows affected:"+rows);
		ResultSet resultorder=preparedStatement.executeQuery();
		System.out.println("movieid\t     movirename\tmovieprice");
		while(resultorder.next())
		{
			System.out.println(resultorder.getInt("id")+"\t\t"+resultorder.getString("name")+"\t\t"+resultorder.getInt("price"));
		}
	}
}
