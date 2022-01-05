package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.security.models.User;
import com.spring.security.repo.UserRepository;

@SpringBootApplication
public class SpringSecurityPracticeApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user=new User();
		user.setEmail("abhay@gmail.com");
		user.setPassword(this.bcryptPasswordEncoder.encode("Abhay@123"));
		user.setUsername("Abhay790");
		user.setRole("ROLE_NORMAL");
		this.userRepository.save(user);
		
		User user1=new User();
		user1.setEmail("tushar@gmail.com");
		user1.setPassword(this.bcryptPasswordEncoder.encode("Tushar@123"));
		user1.setUsername("Tushar790");
		user1.setRole("ROLE_ADMIN");
		this.userRepository.save(user1);
	}
	
}
