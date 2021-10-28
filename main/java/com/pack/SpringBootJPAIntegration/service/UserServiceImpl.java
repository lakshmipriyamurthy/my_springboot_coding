package com.pack.SpringBootJPAIntegration.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pack.SpringBootJPAIntegration.model.User;
import com.pack.SpringBootJPAIntegration.repository.UserRepository;





@Service
public  class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	//@Autowired
	//private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(user.getRole());
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}


	/*@Override
	public void saveRole(Iterable i) {
		roleRepository.saveAll(i);
	}*/
}
