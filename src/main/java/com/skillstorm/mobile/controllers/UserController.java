package com.skillstorm.mobile.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.mobile.Service.UserService;
import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.UserRepo;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private UserService us;
	/*
	@GetMapping(value="/user")
	public Optional<User> showUserInfo()
	{
		int num=4;
		User user=  us.findById(num);
	    //return Optional.ofNullable(user);
		System.out.println(user);
		//return Optional.ofNullable(user);
		return Optional.of(user);
		
		
	}
	*/
	@GetMapping(value="/user")            //showing all user info to a User
	public User showUserInfo()
	{
		int num=1;
		User user=  us.findUser(num);
	    return user;
		
		
	}
	@PostMapping()                          //Adding User
	public ResponseEntity<User> insertUser(@RequestBody @Valid User user)
	{
		User body= us.saveUser(user);
		return new ResponseEntity<>(body, HttpStatus.CREATED);
		
	}
	
	@PutMapping()
	public User updateUser(@RequestBody User user)
	{
		int id=3;
		return us.updateUserInfo(user,id);
		//System.out.println(updatedUser);
		//return updatedUser;
		
	}
	
	
	

	
	
	
	
	
	

}
