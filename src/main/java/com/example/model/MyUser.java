package com.example.model;

import java.sql.Timestamp;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/*Model class for user data*/
@Entity
@Table(name="customers")
public class MyUser {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="registered")
	private Timestamp registered;
	
	
	@Column(name="email_address", nullable=false, unique=true, length=255)
	private String email;
	
	@Column(name="title", nullable=false, length=5)
	private String title;
	
	@Column(name="first_name", nullable=false, length=50)
	private String first_name;
	
	@Column(name="last_name", nullable=false, length=50)
	private String last_name;
	
	@Column(name="address_line_1", nullable=false, length=255)
	private String address_line_1;
	
	@Column(name="address_line_2", length=255)
	private String address_line_2;
	
	@Column(name="city", length=255)
	private String city;
	
	@Column(name="postcode", nullable=false, length=10)
	private String postcode;
	
	@Column(name="phone_number", length=20)
	private String phone_number;
	
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getRegistered() {
		return registered;
	}
	public void setRegistered(Timestamp registered) {
		this.registered = registered;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email_address) {
		this.email = email_address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAddress_line_1() {
		return address_line_1;
	}
	public void setAddress_line_1(String address_line_1) {
		this.address_line_1 = address_line_1;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "MyUser [id=" + id + ", registered=" + registered + ", email_address=" + email + ", title="
				+ title + ", first_name=" + first_name + ", last_name=" + last_name + ", address_line_1="
				+ address_line_1 + ", address_line_2=" + address_line_2 + ", city=" + city + ", postcode=" + postcode
				+ ", phone_number=" + phone_number + "]";
	}
	

}
