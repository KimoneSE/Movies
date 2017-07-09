package com.movie.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserDao;
import com.movie.model.User;
import com.movie.service.UserManageService;

@Service
@Transactional
public class UserManagerServiceImpl implements UserManageService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public Map<String, Object> register(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username==null||password==null){
			map.put("success", false);
			map.put("tip", "请输入完整信息");
		}else {
			username = username.trim();
			password = password.trim();
			if(username.length()==0||password.length()==0){
				map.put("success", false);
				map.put("tip", "请输入完整信息");
			}else {
				User user = userDao.findByUsername(username);
				if(user!=null){
					map.put("success", false);
					map.put("tip", "该用户名已被占用");
				}else {
					user = userDao.createUser(username, password);
					map.put("success", true);
					map.put("username", user.getUsername());
				}
				
			}
		}
		
		return map;
	}

	@Override
	public Map<String, Object> login(String username, String password) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(username==null||password==null){
			map.put("success", false);
			map.put("tip", "请输入完整信息");
		}else {
			username = username.trim();
			password = password.trim();
			if(username.length()==0||password.length()==0){
				map.put("success", false);
				map.put("tip", "请输入完整信息");
			}else {
				User user = userDao.findByUsername(username);
				if(user==null){
					map.put("success", false);
					map.put("tip", "用户名或密码错误");
				}else {
					map.put("success", true);
					map.put("username", user.getUsername());
				}
			}
		}
		return map;
	}

	@Override
	public User findByUsername(String username) {
		return userDao.findByUsername(username);
	}

}
