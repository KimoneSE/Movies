package com.data.interfaces;

import java.util.List;

import com.vo.CommentVO;
import com.vo.MovieDetailVO;

public interface MovieDetails {
	/**
	 * ͨ����Ӱ������ȡ��Ӱ����ϸ��Ϣ
	 * @param movieName
	 * @return ��Ӱϸ��
	 */
	public MovieDetailVO getDetailByName(String movieName);
	
	public List<CommentVO> getMoreComments(String movieName, int page);
}
