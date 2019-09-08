package com.dev.beans;

public class User {

	private int userId;
	private String firstName;
	private String lastName;
	private String password;

	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	public String getFirstName() 
	{
		return firstName;
	}
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	public String getLastName() 
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [User Id=" + userId + ", First Name=" + firstName + ", Last Name=" + lastName + ", Password="
				+ password + "]";
	}



}