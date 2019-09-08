package com.caps.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.caps.beans.User;

public class JDBCImpl implements UserDAO{

	@Override
	public Boolean createProfile(User user) {
	
		int uid = 0 ;
		String fname =null;
		String lname= null;
		String passwd= null;
		
		
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;

		try
		{
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.get the DB connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			con =DriverManager.getConnection(dbUrl,"root", "root");

			//3.Issue the SQL Query via connection
			String sql="insert into users_info values(?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,uid);
			pstmt.setString(2,fname);
			pstmt.setString(3,lname);
			pstmt.setString(4,passwd);

			count =pstmt.executeUpdate();

			//4.Process the result


		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			//close the JDBC objects
			if(con!=null) 
			{
				try {

					con.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();

				}
			}
			if( pstmt!=null)
			{
				try
				{

					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		if(count>0)
			return true;
		else 
			return false;
	}


	@Override
	public User searchUser(Integer userId) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;

		try {
			//1.Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2 get db conection

			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);

			//3.Issue sql query
			String sql="SELECT * FROM users_info where user_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			rs=pstmt.executeQuery();

			//4.process the result
			if(rs.next())
			{

				int userid = rs.getInt("user_id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String password = rs.getString("password");
				user=new User();
				user.setUserId(userid);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(password);

			}
			else
				return null;

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			//5.Close the objects

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return user;

	}





	@Override
	public Boolean updatePassword(Integer userId, String oldPassword, String newPassword) {

		String oldPassword1=oldPassword;
		String newPassword1=newPassword;


		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;

		try
		{
			//1.Load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2.get the DB connection via driver
			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
			con =DriverManager.getConnection(dbUrl,"root", "root");

			//3.Issue the SQL Query via connection

			String sql="update users_info set password=? where password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,newPassword1);
			pstmt.setString(2, oldPassword);



			count =pstmt.executeUpdate();

			//4.Process the result

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			//5.Close the objects

			if(con != null){
				try {
					con.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		if(count>0)
			return true;
		else 
			return false;
	}



	@Override
	public Boolean deleteUser(Integer userId, String password) { 
		Connection con=null;
		PreparedStatement pstmt=null;
		int count=0;
		try {
			//1.Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2 get db conection

			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);

			//3.Issue the SQL Query via connection
			String sql="delete from users_info where user_id=? and password=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			pstmt.setString(2,password );


			count =pstmt.executeUpdate();

			//4.Process the result


		}


		catch(Exception e)
		{
			e.printStackTrace();



		}
		finally {
			//5.Close the objects

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(count>0)
			return true;

		else 
			return false;
	}
	@Override
	public User login(Integer userId, String password) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		User user=null;

		try {
			//1.Load driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			//2 get db conection

			String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db"
					+ "?user=root&password=root";
			con = DriverManager.getConnection(dbUrl);

			//3.Issue sql query
			String sql="SELECT * FROM users_info where user_id=? and password=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setInt(1, userId);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();

			//4.process the result
			if(rs.next())
			{

				int userid = rs.getInt("user_id");
				String firstName = rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String password1 = rs.getString("password");
				user=new User();
				user.setUserId(userid);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setPassword(password1);
			}
			else
				return null;

		}catch(Exception e)
		{
			e.printStackTrace();
		} 
		finally {
			//5.Close the objects

			if(con != null){
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null){
				try {
					pstmt.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
				}
			}


		}
		return user;

	}



}


