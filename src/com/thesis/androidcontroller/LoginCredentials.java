package com.thesis.androidcontroller;

public class LoginCredentials {

	private int _id;
	String _username;
	String _password;
	String _fullname;
	
	public LoginCredentials() {}
	
	public LoginCredentials(int id, String username, String password, String fullname) {
		
			this._id 	   = id;
			this._username = username;
			this._password = password;
			this._fullname = fullname;
	}
	
	public LoginCredentials( String username, String password, String fullname) {
		
		this._username = username;
		this._password = password;
		this._fullname = fullname;
}
	
	public int getId() {
		return this._id;
	}
	
	public String getUsername() {
		return this._username;
	}
	
	public String getPassword() {
		return this._password;
	}
	
	public String getFullname() {
		return this._fullname;
	}
	
	public void setUsername(String username) {
		this._username = username;
	}
	
	public void setPassword(String password) {
		this._password = password;
	}
	
	public void setFullname(String fullname) {
		this._fullname = fullname;
	}
}
