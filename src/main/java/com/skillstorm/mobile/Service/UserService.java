package com.skillstorm.mobile.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillstorm.mobile.models.User;
import com.skillstorm.mobile.repository.UserRepo;




@Service
public class UserService {
	
	@Autowired
	private UserRepo ur;
	/*
	public User findById(Integer id)
	{
        Optional <User> optional=  ur.findById(id);
		
		if(optional.isPresent())
		{
			return optional.get();
		}
		else
		{
			return new User();
		}
		//return null;
	}
	*/
	
	public User findUser(int id)
	{
       // Optional <User> optional=  ur.findById(id);
		Optional<User> optional=ur.findById(id);
		User tempUser=optional.get();
		System.out.println(tempUser);
		return tempUser;
		/*
		if(optional.isPresent())
		{
			
		}
		else
		{
			return new User();
		}
		*/
		//return null;
	}
	
	public User saveUser(User user)
	{
        User body= ur.save(user);
		return body;
		
	}
	
	public User updateUserInfo(User user,int id)
	{
		Optional<User> optional=ur.findById(id);
		User tempUser=optional.get();
		return ur.save(tempUser);
		/*
		if(ur.findById(user.getUserID()).isPresent())
		{
			return ur.save(user);
		}
		else
		{
			return new User();
		}
		*/
	}

}
