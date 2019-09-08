package com.ums.beans;

public class User 
{

	private int usersId;
	private String firstName;
	private String lastName;
	private String password;

	public int getUsersId() 
	{
		return usersId;
	}
	public void setUsersId(int usersId)
	{
		this.usersId = usersId;
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
	public String toString() 
	{
		return "User [usersId=" + usersId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}
}
