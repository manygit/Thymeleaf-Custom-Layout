package org.kshrd.model;

public class UserModel {
	private int id;
	private String name;
	private String gender;
	private String email;
	private String role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public UserModel(int id, String name, String gender,String email, String role) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.role = role;
	}
	public UserModel() {}
}
