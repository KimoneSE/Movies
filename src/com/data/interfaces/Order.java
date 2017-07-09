package com.data.interfaces;

import java.util.List;

import com.vo.CinemaVO;


public interface Order {
	
	public List<CinemaVO> getCinemaByArea(String city);
	
	
	
}
