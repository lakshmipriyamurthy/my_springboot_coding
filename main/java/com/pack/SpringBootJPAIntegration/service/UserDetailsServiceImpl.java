package com.pack.SpringBootJPAIntegration.service;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pack.SpringBootJPAIntegration.model.Role;
import com.pack.SpringBootJPAIntegration.model.User;
import com.pack.SpringBootJPAIntegration.repository.UserRepository;





@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username); //getting username from database

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Role role=user.getRole();
        //Represents an authority granted to an Authentication object.
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        

        return new org.springframework.security.core.userdetails.User(user.getUsername(), 
        		user.getPassword(), grantedAuthorities);
    }
}
