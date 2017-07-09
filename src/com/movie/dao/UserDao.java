package com.movie.dao;

import com.movie.model.User;

public interface UserDao {
	public User createUser(String username,String password);
	public User findByUsername(String username);
}
