package com.skillstorm.mobile.models;

import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Device_Name")
	@NotBlank
	private String name;

	@Column
	@Min(value = 0, message = "Price is more than one")
	private Double price;
	
	//Many device can have one User
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="USER_ID") //FOREIGN Key
	//@JsonIgnore
	private User user;

	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Device(@NotBlank String name, @Min(value = 0, message = "Price is more than one") Double price, User user) 
	{
		super();
		this.name = name;
		this.price = price;
		this.user = user;
	}
	
	

	public Device(int id, @NotBlank String name,@Min(value = 0, message = "Price is more than one") Double price) 
	{
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Device( User tempUser) {
		this.user=tempUser;
	}


	public Device(int id, @NotBlank String name,@Min(value = 0, message = "Price is more than one") Double price, User tempUser) 
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.user=tempUser;
		
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
    /*
	@Override
	public String toString() {
		return "Device [deviceID=" + deviceID + ", name=" + name + ", price=" + price + ", user=" + user + "]";
	}
	*/
	@Override
	public String toString() {
		return "Device [id=" + id + ", name=" + name + ", price=" + price + ", user=" + user + "]";
	}
	
	

}
