package com.dev.ums.beans;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	
	@Override
	public String toString() {
		return "User [User Id=" + userId + ", First Name=" + firstName + ", Last Name=" + lastName +", Email=" + email + ", Password="
				+ password + "]";
	}
}