package com.mongodb.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
public class Student {

	private long id;
	private String name;
	private  String city;
	private String phone;
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long id, String name, String city, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", phone=" + phone + "]";
	}
	
}
