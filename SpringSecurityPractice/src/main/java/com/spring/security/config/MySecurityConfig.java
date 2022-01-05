package com.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.security.services.CustomUserDetailService;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/signin").permitAll()
		.antMatchers("/public/**").hasRole("NORMAL")
		.antMatchers("/users/**").hasRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/signin")
		.loginProcessingUrl("/dologin")
		.defaultSuccessUrl("/users/");
		//.httpBasic();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//		auth.inMemoryAuthentication().withUser("Abhay").password(this.passwordEncoder()
//				.encode("Abhay@123")).roles("NORMAL");
//		auth.inMemoryAuthentication().withUser("Tushar").password(this.passwordEncoder().encode("Tushar@123")).roles("ADMIN");
		auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
	}
	//ROLE-High Level Overview->NORMAL:READ
	//Authority-permission->READ
	//ADMIN-READ,WRITE,UPDATE
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder(10);
	}
}
