package com.movie.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.dao.UserDao;
import com.movie.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public User createUser(String username, String password) {
		Session session = sessionFactory.getCurrentSession();
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		session.save(user);
		return user;
	}

	@Override
	public User findByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where username='"+username+"'");
		if(query.list()==null||query.list().size() == 0){
			return null;
		}else{
			return (User)query.list().get(0);
		}
	}

}
