package com.pack.SpringBootJPAIntegration.service;

import com.pack.SpringBootJPAIntegration.model.User;

public interface UserService {
    void save(User user);
   // void saveRole(Iterable i);
    User findByUsername(String username);
}