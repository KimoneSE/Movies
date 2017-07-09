package com.data.impls.detail;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.data.impls.entity.CommentEntity;
import com.data.interfaces.MovieDetails;
import com.vo.CommentVO;
import com.vo.MovieDetailVO;

public class MovieDetailsImpl implements MovieDetails{
	@Autowired
	private SessionFactory factory;
	private final int PAGE_SIZE = 10;
	
	public void setSessionFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public MovieDetailVO getDetailByName(String movieName) {
		
		return null;
	}

	@Override
	public List<CommentVO> getMoreComments(String movieName, int page) {
		List<CommentVO> comments = new LinkedList<>();
		
		StringBuilder sqlGetMovie = new StringBuilder();
		sqlGetMovie.append("select movieId \n");
		sqlGetMovie.append("from DouBanMovieEntity \n");
		sqlGetMovie.append("where movieName = :movieName \n");
		
		StringBuilder sqlGetComments = new StringBuilder();
		sqlGetComments.append("from CommentEntity \n");
		sqlGetComments.append("where movieId = :movieId \n");
		sqlGetComments.append("order by commentTime \n");
		
		Session session = factory.openSession();
		
		Query getMovie = session.createQuery(sqlGetMovie.toString());
		getMovie.setParameter("movieName", movieName);
		
		Integer movieId = (Integer) getMovie.getSingleResult();
		if(movieId == null) {
			System.err.println("INFO>>> movie: " + movieName + " not exist!");
			session.close();
			return comments;
		}
		
		Query getComments = session.createQuery(sqlGetComments.toString());
		getComments.setParameter("movieId", movieId);
		getComments.setFirstResult(page * PAGE_SIZE);
		getComments.setMaxResults(PAGE_SIZE);
		
		List<?> objs = getComments.getResultList();
		for(Object obj: objs) {
			CommentEntity entity = (CommentEntity) obj;
			
			CommentVO vo = new CommentVO();
			vo.setComment(entity.getComment());
			vo.setScore(parseScore(entity.getCommentLevel()));
			vo.setTime(entity.getCommentTime());
			vo.setUsername(entity.getCommentator());
			
			comments.add(vo);
		}
		
		session.close();
		return comments;
	}
	
	private double parseScore(String commentLevel) {
		String[] levels = {"很差", "较差", "还行", "推荐", "力荐"};
		for(int counter = 0; counter < levels.length; counter++) {
			if(levels[counter].equals(commentLevel)) {
				return counter + 1;
			}
		}
		return 0;
	}

}
