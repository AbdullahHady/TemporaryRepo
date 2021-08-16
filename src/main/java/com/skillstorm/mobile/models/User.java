package com.skillstorm.mobile.models;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table

public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userID;
	
	@Column
	@NotBlank
	private String userName;
	
	@Column
	private String password;
	
	@Email
	@Column
	private String email;
	
	@Column
	private String homeAddress;
    
	//One User can have many devices
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Column
	private List<Device> device; //= new ArrayList<Device>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public User(@NotBlank String userName, String password, @Email String email, String homeAddress,
			List<Device> device) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.homeAddress = homeAddress;
		this.device = device;
	}
	
	
	
	public User( int userID,@NotBlank String userName, String password, @Email String email, String homeAddress) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.homeAddress = homeAddress;
	}
	
	
	
    
	public User(@NotBlank String userName, String password, @Email String email, String homeAddress) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.homeAddress = homeAddress;
	}

	public User(int userID) {
		super();
		this.userID = userID;
	}


	public int getUserID() {
		return userID;
	}
    public void setUserID(int userID) {
		this.userID = userID;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public List<Device> getDevice() {
		return device;
	}

	public void setDevice(List<Device> device) {
		this.device = device;
	}
    /*
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", homeAddress=" + homeAddress + ", device=" + device + "]";
	}
	*/
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", homeAddress=" + homeAddress + "]";
	}
	
}	


