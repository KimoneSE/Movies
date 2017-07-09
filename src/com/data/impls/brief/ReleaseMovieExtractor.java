package com.data.impls.brief;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.data.impls.entity.ReleaseMovieEntity;
import com.vo.ReleaseMovieVO;

public class ReleaseMovieExtractor {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 这个是用来做单元测试的
	 * @param sessionFactory 
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public List<ReleaseMovieVO> getReleaseMovie(Date date){
		List<ReleaseMovieVO> releaseMovies = new LinkedList<>();
		Session session = sessionFactory.openSession();
		
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("from ReleaseMovieEntity \n");
		sqlBuilder.append("where DAY(time) = DAY(:theDay) \n");
		
		Query query = session.createQuery(sqlBuilder.toString());
		query.setParameter("theDay", date, TemporalType.DATE);
		
		List<?> resultSet = query.getResultList();
		
		for(Object result: resultSet) {
			ReleaseMovieEntity entity = (ReleaseMovieEntity) result;
			
			ReleaseMovieVO vo = new ReleaseMovieVO();
			vo.setDirector(entity.getDirector());
			vo.setDuration(entity.getDuration());
			vo.setImg(entity.getImg());
			vo.setMovieName(entity.getMovieName());
			vo.setRegion(entity.getRegion());
			vo.setReleaseTime(entity.getReleaseTime());
			vo.setScore(entity.getScore());
			vo.setStar(entity.getStar());
			vo.setTime(entity.getTime());
			
			releaseMovies.add(vo);
		}
		
		session.close();
		
		return releaseMovies;
	}
}
