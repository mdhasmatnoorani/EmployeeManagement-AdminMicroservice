package com.adminmicroservice.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@Column(name="admin_email_id")
	private String adminEmailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	

	public Admin() {
		super();
	}



	public Admin(String adminEmailId, String password, String firstName, String lastName) {
		super();
		this.adminEmailId = adminEmailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public String getAdminEmailId() {
		return adminEmailId;
	}



	public void setAdminEmailId(String adminEmailId) {
		this.adminEmailId = adminEmailId;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	@Override
	public String toString() {
		return "Admin [adminEmailId=" + adminEmailId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + "]";
	}

	
	
	
}
