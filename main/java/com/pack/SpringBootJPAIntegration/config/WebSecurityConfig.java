package com.pack.SpringBootJPAIntegration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration // defines bean configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception{

		http.authorizeRequests()
		.antMatchers("/registeration").permitAll()
		.antMatchers("/").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/new").hasAnyAuthority("USER","ADMIN")
		.antMatchers("/editProduct/**").hasAnyAuthority("ADMIN")
		.antMatchers("/deleteProduct/**").hasAnyAuthority("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.loginPage("/login") 
				.permitAll()
				.and()
		.logout()
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/403");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		//auth.inMemoryAuthentication().withUser("priya").password("abcd").roles("admin");
		auth.userDetailsService(userDetailsService).passwordEncoder(bcryptPasswordEncoder());  
		}
																	
}
