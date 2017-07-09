package com.movie.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.dao.MovieDao;
import com.movie.model.BoxOffice;
import com.movie.model.Cinema;
import com.movie.model.Movie;

@Repository
public class MovieDaoImpl implements MovieDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Session session;

	@Override
	public List getAllRelease() {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();
			// Date today = new Date();
			// SimpleDateFormat adf = new SimpleDateFormat("yyyy-MM-dd");
			// String dateString = adf.format(today);
			Query query = session.createQuery("from Movie");
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List getRank() {
		session = sessionFactory.getCurrentSession();
		String sql = "from Movie order by score desc";
		List list = session.createQuery(sql).list();
		return list;
	}

	// @Override
	// public List getAllMovies() {
	// // TODO Auto-generated method stub
	// List list = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from Movie");
	// list = query.list();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return list;
	// }
	//
	// @Override
	// public List getAllComing() {
	// // TODO Auto-generated method stub
	// List list = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from ComingMovie");
	// list = query.list();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return list;
	// }

	// @Override
	// public ReleaseMovie getRelease(String mname) {
	// // TODO Auto-generated method stub
	// ReleaseMovie rm = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from ReleaseMovie where
	// movieName='"+mname+"'");
	// List list = query.list();
	//
	// if(list!=null&&list.size()>0){
	// rm = (ReleaseMovie) list.get(0);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return rm;
	// }
	//
	// @Override
	// public ComingMovie getComing(String mname) {
	// // TODO Auto-generated method stub
	// ComingMovie cm = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from ReleaseMovie where
	// movie='"+mname+"'");
	// List list = query.list();
	//
	// if(list!=null&&list.size()>0){
	// cm = (ComingMovie) list.get(0);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return cm;
	// }

	@Override
	public Movie getMovie(int id) {
		// TODO Auto-generated method stub
		Movie m = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Movie where movieId=" + id);
			List list = query.list();

			if (list != null && list.size() > 0) {
				m = (Movie) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	public Movie getMovie(String name) {
		Movie m = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Movie where movieName='" + name + "'");
			List list = query.list();

			if (list != null && list.size() > 0) {
				m = (Movie) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}

	@Override
	public int getMovieId(String name) {
		int id = 0;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("select movieId from Movie where movieName='" + name + "'");
			List list = query.list();

			if (list != null && list.size() > 0) {
				id = (int) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	@Override
	public double getBoxoffice(String mname) {
		// TODO Auto-generated method stub
		double boxoffice = 0.00;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from BoxOffice where movieName='" + mname + "'");
			List list = query.list();

			if (list != null && list.size() > 0) {
				BoxOffice b = (BoxOffice) list.get(0);
				boxoffice = b.getBoxOffice();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return boxoffice;
	}

	@Override
	public List getComments(int id) {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Comment where movieId=" + id + " order by commentTime desc");
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List getActors(int id) {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from MovieActor where movieId=" + id);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List getDirectors(int id) {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from MovieDirector where movieId=" + id);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List getTags(int id) {
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from MovieTag where movieId=" + id);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// @Override
	// public DownloadLink getDownloadLink(String mname) {
	// // TODO Auto-generated method stub
	// DownloadLink dl = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from DownloadLink where
	// name='"+mname+"'");
	// List list = query.list();
	//
	// if(list!=null&&list.size()>0){
	// dl = (DownloadLink) list.get(0);
	// }
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return dl;
	// }

	@Override
	public List getAllCinemas() {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Cinema");
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List getMovieTickets(int mid, int cid) {
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Ticket where movieId=" + mid + " and cinemaId=" + cid);
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// @Override
	// public List getAllPrice(String mname) {
	// // TODO Auto-generated method stub
	// List list = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from Price where
	// movieName='"+mname+"'");
	// list = query.list();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return list;
	// }
	//
	// @Override
	// public List getAllPriceDetail(String mname,String cid) {
	// // TODO Auto-generated method stub
	// List list = null;
	//
	// try {
	// session=sessionFactory.getCurrentSession();
	//
	// Query query = session.createQuery("from PriceDetail where id='"+cid+"'
	// and movieName='"+mname+"'");
	// list = query.list();
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	//
	// return list;
	// }

	@Override
	public List getAllCinemaNames() {
		// TODO Auto-generated method stub
		List list = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("select distinct cinemaName from Cinema");
			list = query.list();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Cinema getCinema(int cid) {
		// TODO Auto-generated method stub
		Cinema c = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Cinema where cinemaId=" + cid);
			List list = query.list();

			if (list != null && list.size() > 0) {
				c = (Cinema) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Cinema getCinema(String cname) {
		// TODO Auto-generated method stub
		Cinema c = null;

		try {
			session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from Cinema where cinemaName='" + cname + "'");
			List list = query.list();

			if (list != null && list.size() > 0) {
				c = (Cinema) list.get(0);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}
