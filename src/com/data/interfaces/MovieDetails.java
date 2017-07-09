package com.data.interfaces;

import java.util.List;

import com.vo.CommentVO;
import com.vo.MovieDetailVO;

public interface MovieDetails {
	/**
	 * 通过电影名来获取电影的详细信息
	 * @param movieName
	 * @return 电影细节
	 */
	public MovieDetailVO getDetailByName(String movieName);
	
	public List<CommentVO> getMoreComments(String movieName, int page);
}
