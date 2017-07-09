package com.movie.service;

import java.util.Map;

import com.movie.model.User;

public interface UserManageService {
	public Map<String, Object> register(String username, String password);

    public Map<String, Object> login(String username, String password);
    
    public User findByUsername(String username); 
}
