package com.movie.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.MovieDao;
import com.movie.model.Cinema;
import com.movie.model.ComingMovie;
import com.movie.model.DownloadLink;
import com.movie.model.Movie;
import com.movie.model.Price;
import com.movie.model.PriceDetail;
import com.movie.model.ReleaseMovie;
import com.movie.service.MovieManageService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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

	@Override
	public List getAllMovies() {
		// TODO Auto-generated method stub
		return movieDao.getAllMovies();
	}

	@Override
	public List getAllComing() {
		// TODO Auto-generated method stub
		return movieDao.getAllComing();
	}

	@Override
	public Map getDetail(String mname) {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		
		Movie movie = movieDao.getMovie(mname);
		DownloadLink dl = movieDao.getDownloadLink(mname);
		List actors = movieDao.getActors(mname);
		List directors = movieDao.getDirectors(mname);
		
		if(movie!=null){
			map.put("name", movie.getMovie());
			map.put("img", movie.getImg());
			map.put("duration", movie.getDuring());
			map.put("region", movie.getRegion());
			map.put("releaseTime", movie.getReleaseTime());
			map.put("score", (double)movie.getScore()/10);
			map.put("introduction", movie.getIntroduce());
		}
		
		if(actors!=null){
			map.put("actors", actors);
		}
		
		if(directors!=null){
			map.put("directors", directors);
		}
		
		if(dl!=null){
			map.put("downloadlink", dl);
		}
		
		return map;
	}

	@Override
	public List getComments(String mname) {
		// TODO Auto-generated method stub
		return movieDao.getComments(mname);
	}

	@Override
	public JSONArray getAllCinemaNames() {
		// TODO Auto-generated method stub
		JSONArray jsonArray = JSONArray.fromObject(movieDao.getAllCinemaNames());
		return jsonArray;
	}

	@Override
	public List getAllPriceInfo(String mname) {
		// TODO Auto-generated method stub
		List pricelist = movieDao.getAllPrice(mname);
		List res = new ArrayList();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		for(int i = 0;i<pricelist.size();i++){
			Map map = new HashMap();
			Price p = (Price) pricelist.get(i);
			String cid = p.getId();
			Cinema c = movieDao.getCinema(cid);
			List ptimelist = movieDao.getAllPriceDetail(mname, cid);
			
			map.put("cinema", c);
			map.put("price", p.getPrice());
			
			JSONArray array = new JSONArray();
			
			for(int j = 0;j<ptimelist.size();j++){
				JSONObject json = new JSONObject();
				PriceDetail pd = (PriceDetail) ptimelist.get(j);
//				System.out.println("*****:"+pd.getTime());
				json.put("cid", pd.getId());
				json.put("movieName", pd.getMovieName());
				json.put("time", pd.getTime().toString());
				json.put("orderLink", pd.getOrderLink());
				
				array.add(json);
			}
			map.put("ptime", array);
			res.add(map);
		}
		
		return res;
	}

}
