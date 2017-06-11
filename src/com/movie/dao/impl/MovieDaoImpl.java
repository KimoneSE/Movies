package com.movie.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.movie.model.Cinema;
import com.movie.model.ComingMovie;
import com.movie.model.Comment;
import com.movie.model.DownloadLink;
import com.movie.model.Movie;
import com.movie.model.Rank;
import com.movie.model.ReleaseMovie;

@Repository
public class MovieDaoImpl  implements MovieDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public List getAllRelease() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			Date today = new Date();
			SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
			 String dateString = adf.format(today);
			Query query = session.createQuery("from ReleaseMovie where time='"+dateString+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getRank() {
		session = sessionFactory.getCurrentSession();
		String sql = "from Rank order by boxOffice desc";
		List list = session.createQuery(sql).list();
		return list;
	}

	@Override
	public List getAllMovies() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Movie");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getAllComing() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from ComingMovie");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public ReleaseMovie getRelease(String mname) {
		// TODO Auto-generated method stub
		ReleaseMovie rm = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from ReleaseMovie where movieName='"+mname+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				rm = (ReleaseMovie) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return rm;
	}

	@Override
	public ComingMovie getComing(String mname) {
		// TODO Auto-generated method stub
		ComingMovie cm = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from ReleaseMovie where movie='"+mname+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				cm = (ComingMovie) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return cm;
	}

	@Override
	public Movie getMovie(String mname) {
		// TODO Auto-generated method stub
		Movie m = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Movie where movie='"+mname+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				m = (Movie) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return m;
	}

	@Override
	public double getBoxoffice(String mname) {
		// TODO Auto-generated method stub
		double boxoffice = 0.00;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Rank where movie='"+mname+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				Rank r = (Rank) list.get(0);
				boxoffice = r.getBoxOffice();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return boxoffice;
	}

	@Override
	public List getComments(String mname) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Comment where movie='"+mname+"' order by time desc");
			list = query.list();
			System.out.println(((Comment)list.get(3)).getComment()+"**************");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getActors(String mname) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Actor where movieName='"+mname+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getDirectors(String mname) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Director where movieName='"+mname+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public DownloadLink getDownloadLink(String mname) {
		// TODO Auto-generated method stub
		DownloadLink dl = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from DownloadLink where name='"+mname+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				dl = (DownloadLink) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return dl;
	}

	@Override
	public List getAllCinemas() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Cinema");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getAllPrice(String mname) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Price where movieName='"+mname+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getAllPriceDetail(String mname,String cid) {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from PriceDetail where id='"+cid+"' and movieName='"+mname+"'");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public List getAllCinemaNames() {
		// TODO Auto-generated method stub
		List list = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("select distinct name from Cinema");
			list = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return list;
	}

	@Override
	public Cinema getCinema(String cid) {
		// TODO Auto-generated method stub
		Cinema c = null;
		
		try {
			session=sessionFactory.getCurrentSession();
			
			Query query = session.createQuery("from Cinema where id='"+cid+"'");
			List list = query.list();
			
			if(list!=null&&list.size()>0){
				c = (Cinema) list.get(0);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return c;
	}

}
