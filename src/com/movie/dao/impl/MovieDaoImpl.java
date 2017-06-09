package com.movie.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.dao.MovieDao;
import com.movie.model.ReleaseMovie;

@Repository
public class MovieDaoImpl  implements MovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	private static MovieDaoImpl movieDao = new MovieDaoImpl();
	
	private MovieDaoImpl(){
		
	}
	
	public static MovieDaoImpl getInstance(){
		return movieDao;
	}

	@Override
	public List getAllRelease() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
//			config = new Configuration().configure();
//			config.addAnnotatedClass(ReleaseMovie.class);
//			serviceRegistry =new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
//			sessionFactory=config.buildSessionFactory(serviceRegistry);	
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from ReleaseMovie");
			list = query.list();
			System.out.println("m:"+((ReleaseMovie)list.get(2)).getMovieName());
//			session.close();
//			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

}
