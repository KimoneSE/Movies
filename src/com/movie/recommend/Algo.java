package com.movie.recommend;

import java.util.ArrayList;

public interface Algo {
	/**
	 * 算法的公共接口
	 * @param rate
	 * @param films
	 * @return
	 */
	ArrayList<Double> contentRec(ArrayList<Integer> rate,
			ArrayList<ArrayList<Integer>> films);

}
