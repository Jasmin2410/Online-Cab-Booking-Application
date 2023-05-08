package com.masai.model;

public class DriverDTO {


	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public DriverDTO() {
		// TODO Auto-generated constructor stub
	}
	public DriverDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	

}
