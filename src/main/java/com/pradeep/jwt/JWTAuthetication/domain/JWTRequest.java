package com.pradeep.jwt.JWTAuthetication.domain;

public class JWTRequest {

	String username;
	String password;
	
	public JWTRequest() {
	}
	
	public JWTRequest(String username,String password) {
		this.username=username;
		this.password=password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "JWTRequest{"+
				"username='"+username+'\''+
				"password='"+password+'\''+
				'}';
	}
}