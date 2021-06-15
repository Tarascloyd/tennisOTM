package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRepository userRepo;

	public UserDetailsServiceImpl(UserRepository userRepo) {
	  this.userRepo = userRepo;
	}
	  
	@Override
	public UserDetails loadUserByUsername(String username)
	    throws UsernameNotFoundException {
	  User user = userRepo.findByUsername(username);
	  if (user != null) {
	    return user;
	  }
	  throw new UsernameNotFoundException(
	                    "User '" + username + "' not found");
	}

}
