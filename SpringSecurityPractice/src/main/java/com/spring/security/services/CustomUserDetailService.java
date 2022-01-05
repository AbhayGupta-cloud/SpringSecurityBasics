package com.spring.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.security.models.CustomUserDetail;
import com.spring.security.models.User;
import com.spring.security.repo.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=this.userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("NO USER");
		}
		return new CustomUserDetail(user);
	}

}
