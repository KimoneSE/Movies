package com.data.impls.brief;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vo.BoxOfficeVO;

public class BoxOfficeExtractor {
	@Autowired
	private SessionFactory sessionFactory;
	
	List<BoxOfficeVO> getBoxOffice(){
		return null;
	}
}
