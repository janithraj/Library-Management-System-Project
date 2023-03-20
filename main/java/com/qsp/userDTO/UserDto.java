package com.qsp.userDTO;

public class UserDto {
	
	private String email;
	private String password;
	private String contactno;
	private String name;
	
	public UserDto(){
		
	}

	public UserDto(String email, String password, String contactno, String name) {
		super();
		this.email = email;
		this.password = password;
		this.contactno = contactno;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
