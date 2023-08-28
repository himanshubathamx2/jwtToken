package com.jwt.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.example.DAO.UserRepository;
import com.jwt.example.entity.User;

@Service
public class CustomDetailService implements UserDetailsService
{
	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=userRepo.findByEmail(username).orElseThrow(()->new RuntimeException("User not found"));
		return user;
	}

}
