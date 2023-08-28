package com.jwt.example.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.example.Service.UserService;
import com.jwt.example.entity.User;

@RestController
@RequestMapping("/home")
public class HomeController
{
	@Autowired
	UserService userService;
	
	//http://lh:8000/home/users
	@GetMapping("/users")
	public List<User> getUser()
	{
		System.out.println("getting users");
		return userService.getUsers();
	}
	
	@GetMapping("/current-user")
	public String getLoggedInUser(Principal principal)
	{
		return  principal.getName();
	}
	
	
	
}
