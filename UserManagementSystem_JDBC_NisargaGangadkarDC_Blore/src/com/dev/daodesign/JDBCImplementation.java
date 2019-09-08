package com.dev.daodesign;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dev.beans.User;

public class JDBCImplementation implements UserDaoDesign {
	// SEARCH User
		@Override
		public User SearchUserProfile(int userId) 
		{
			Connection con = null;
			PreparedStatement pstmt =null;
			ResultSet rs= null;
			User user = null;
			try 
			{
				//1. Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//2. Get the DB connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db?user=root&password=root";
				con = DriverManager.getConnection(dbUrl);

				//3. Issue the SQL query via connection
				String sql = "SELECT * from users_info WHERE user_id=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				rs= pstmt.executeQuery();

				//4. Process the result returned by SQL query

				if(rs.next())
				{
					userId = rs.getInt("user_id");				
					String firstname = rs.getString("firstname");					
					String lastname = rs.getString("lastname");		
					String passwd = rs.getString("password");
					
					user = new User();
					user.setUserId(userId);
					user.setFirstName(firstname);
					user.setLastName(lastname);
					user.setPassword(passwd);
				}
				else
				{
					return null;
				}
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 5. close all the JDBC objects
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
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
			return user;
		}



		// DELETE User
		@Override
		public boolean deleteUserProfile(int userId, String password) 
		{

			int count = 0 ;
			Connection con = null;
			PreparedStatement pstmt = null;

			try 
			{
				//1. Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//2. Get the DB connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db?user=root&password=root";
				con = DriverManager.getConnection(dbUrl);

				//3. Issue the SQL query via connection
				String sql = "DELETE from users_info WHERE (user_id=? AND password=?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, userId);
				pstmt.setString(2, password);
				count = pstmt.executeUpdate();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

			finally
			{

				// 5. close all JDBC objects

				if(con != null ) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}


					if(pstmt != null) {
						try {
							pstmt.close();
						} catch (SQLException e) {
							e.printStackTrace();
						}
					}
				}
			}
			if(count>0)
			{
				return true;
				//System.out.println("Profile Deleted");
			}
			else
			{
				return false;
				//System.out.println("Profile cannot be Deleted");

			}
		}



		// CREATE User
		@Override
		public boolean createUserProfile(User user) 
		{
			User user1 = new User();
			Scanner in = new Scanner(System.in);
			System.out.println("Enter the user id");
			int uid = Integer.parseInt(in.nextLine());
			System.out.println("Enter the first name");
			String fname = in.nextLine();
			System.out.println("Enter the last name");
			String lname = in.nextLine();
			System.out.println("Enter the password");
			String passwd = in.nextLine();
			in.close();

			user1.setUserId(uid);
			user1.setFirstName(fname);
			user1.setLastName(lname);
			user1.setPassword(passwd);

			Connection con = null;
			PreparedStatement  pstmt = null;
			int count = 0;
			try
			{
				//1. load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//2. get the db connection
				String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
				con = DriverManager.getConnection(dbUrl,"root","root");
				//3. Issue the SQL query via connection
				String sql = "Insert into users_info values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, uid);
				pstmt.setString(2, fname);
				pstmt.setString(3, lname);
				pstmt.setString(4, passwd);
				count = pstmt.executeUpdate();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con != null ) {
					try 
					{
						con.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}


					if(pstmt != null) 
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
			}
			if(count>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		}






		// UPDATE Password
		@Override
		public boolean updateUserPassword(String oldPassword, String newPassword)
		{
			Connection con = null;
			PreparedStatement  pstmt = null;
			int count = 0;
			try
			{
				//1. load the driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//2. get the db connection
				String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db";
				con = DriverManager.getConnection(dbUrl,"root","root");

				//3. Issue the SQL query via connection
				String sql = "update users_info set password=? where password=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, newPassword);
				pstmt.setString(2, oldPassword);
				count = pstmt.executeUpdate();
			}

			// 4. Process the result

			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 5. close all JDBC objects
				if(con != null ) {
					try 
					{
						con.close();
					} 
					catch (SQLException e1) 
					{
						e1.printStackTrace();
					}


					if(pstmt != null) 
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
			}
			{
				if(count>0)
				{
					return true;
				}
				else
				{
					return false;
				}
			}
		
		}


		@Override
		public ArrayList<User> showAllUsers() 
		{
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs= null;
			ArrayList<User> user = null;
			
			try 
			{
				//1. Load the Driver
				Class.forName("com.mysql.cj.jdbc.Driver");

				//2. Get the DB connection via driver
				String dbUrl="jdbc:mysql://localhost:3306/cleveridiots_db?user=root&password=root";
				con = DriverManager.getConnection(dbUrl);

				//3. Issue the SQL query via connection
				String sql = "SELECT * from users_info";
				pstmt = con.prepareStatement(sql);
				rs= pstmt.executeQuery();
				while(rs.next())
				{
					int userId = rs.getInt("user_id");				
					String firstname = rs.getString("firstname");					
					String lastname = rs.getString("lastname");	
					String passwd = rs.getString("password");

					user = new ArrayList<User>();
					System.out.println("User Id: " + userId);
					System.out.println("First Name: " + firstname);
					System.out.println("Last Name: " + lastname);
					System.out.println("Password: " + passwd);
					System.out.println("*********************");
					
				}
				
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				// 5. close all the JDBC objects
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
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(rs != null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}

			}
			return user;
		}
}



