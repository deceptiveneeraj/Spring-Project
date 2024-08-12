package com.school.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {

	@Id
	int id;
	String name;
	String city;
	String role;
	
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Admin(int id, String name, String city, String role) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.role = role;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", city=" + city + ", role=" + role + "]";
	}
}

