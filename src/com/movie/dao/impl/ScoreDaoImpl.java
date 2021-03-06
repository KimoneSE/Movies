package com.movie.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.dao.ScoreDao;
import com.movie.model.Score;

@Repository
public class ScoreDaoImpl implements ScoreDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	@Transactional
	public void add(Score s) {
		// TODO Auto-generated method stub
		try {
			System.out.println("************");
			System.out.println(s.getUsername());
			session=sessionFactory.getCurrentSession();
			String sqlString = "insert into user_score values(0,"+s.getMovieId()+","+s.getScore()+","+s.getUsername()+")";
			session.createSQLQuery(sqlString);
//			session.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public Score get(String username, int movieId) {
		// TODO Auto-generated method stub
		Score s = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Score where username='"+username+"' and movieId="+movieId);
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				s = (Score) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return s;
	}

	@Override
	public List get(String username) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Score where username='"+username+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

}
