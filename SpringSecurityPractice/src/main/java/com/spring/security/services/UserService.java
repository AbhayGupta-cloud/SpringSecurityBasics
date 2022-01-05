package com.spring.security.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.security.models.User;
@Service
public class UserService {
	List<User> list=new ArrayList<>();
	public UserService() {
		list.add(new User("Abhay","Abhay@1234","abhaygupta@gmail.com"));
		list.add(new User("Tushar","Tushar@1234","tushargupta@gmail.com"));
	}
	//get all users
	public List<User> getAllUsers(){
		return this.list;
	}
	//get single user
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
	}
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
