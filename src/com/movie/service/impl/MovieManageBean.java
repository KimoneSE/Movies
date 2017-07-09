package com.movie.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieDao;
import com.movie.model.Movie;
import com.movie.service.MovieManageService;

import net.sf.json.JSONArray;

@Service
public class MovieManageBean implements MovieManageService{

	@Autowired
	private MovieDao movieDao;
	
	@Override
	public List getAllRelease() {
		// TODO Auto-generated method stub
		return movieDao.getAllRelease();
	}

	@Override
	public List getRank() {
		return movieDao.getRank();
	}

//	@Override
//	public List getAllMovies() {
//		// TODO Auto-generated method stub
//		return movieDao.getAllMovies();
//	}
//
//	@Override
//	public List getAllComing() {
//		// TODO Auto-generated method stub
//		return movieDao.getAllComing();
//	}

	@Override
	public Map getDetail(int id) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		
		Movie movie = movieDao.getMovie(id);
//		DownloadLink dl = movieDao.getDownloadLink(mname);
		List actors = movieDao.getActors(id);
		List directors = movieDao.getDirectors(id);
		List tags = movieDao.getTags(id);
		double boxOffice = movieDao.getBoxoffice(movie.getMovieName());
		
		if(movie!=null){
			map.put("movie", movie);
//			map.put("name", movie.getMovieName());
//			map.put("img", movie.getPoster());
//			map.put("duration", movie.getDuring());
//			map.put("region", movie.getRegion());
//			map.put("language", movie.getLanguage());
//			map.put("releaseTime", movie.getReleaseDate());
//			map.put("score", movie.getScore());
//			map.put("introduction", movie.getSummary());
		}
		
		if(actors!=null){
			map.put("actors", actors);
		}
		
		if(directors!=null){
			map.put("directors", directors);
		}
		
		if(tags!=null){
			map.put("tags", tags);
		}
		
		if(boxOffice>0){
			map.put("boxOffice", boxOffice);
		}
		
//		if(dl!=null){
//			map.put("downloadlink", dl);
//		}
		
		return map;
	}

	@Override
	public List getComments(int id) {
		// TODO Auto-generated method stub
		return movieDao.getComments(id);
	}

	@Override
	public JSONArray getAllCinemaNames() {
		// TODO Auto-generated method stub
		JSONArray jsonArray = JSONArray.fromObject(movieDao.getAllCinemaNames());
		return jsonArray;
	}
	
	@Override
	public List getMovieTickets(int mid,int cid){
		 return movieDao.getMovieTickets(mid, cid);
	}

//	@Override
//	public List getAllPriceInfo(String mname) {
//		// TODO Auto-generated method stub
//		List pricelist = movieDao.getAllPrice(mname);
//		List res = new ArrayList();
////		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		
//		for(int i = 0;i<pricelist.size();i++){
//			Map map = new HashMap();
//			Price p = (Price) pricelist.get(i);
//			String cid = p.getId();
//			Cinema c = movieDao.getCinema(cid);
//			List ptimelist = movieDao.getAllPriceDetail(mname, cid);
//			
//			map.put("cinema", c);
//			map.put("price", p.getPrice());
//			
//			JSONArray array = new JSONArray();
//			
//			for(int j = 0;j<ptimelist.size();j++){
//				JSONObject json = new JSONObject();
//				Ticket pd = (Ticket) ptimelist.get(j);
////				System.out.println("*****:"+pd.getTime());
//				json.put("cid", pd.);
//				json.put("movieName", pd.getMovieName());
//				json.put("time", pd.getTime().toString());
//				json.put("orderLink", pd.getOrderLink());
//				
//				array.add(json);
//			}
//			map.put("ptime", array);
//			res.add(map);
//		}
//		
//		return res;
//	}

}
