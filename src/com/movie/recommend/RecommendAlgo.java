package com.movie.recommend;

import java.util.ArrayList;

public class RecommendAlgo implements Algo{
	/**
	 * 注意参数rate中电影的顺序必须和films中的电影顺序相同
	 * @param rate 用户对所有电影的评分
	 * @param films 所有电影的特征矩阵
	 * @return 用户对每一个特征的偏好
	 */
	
	@Override
	public ArrayList<Double> contentRec(ArrayList<Integer> rate,
			ArrayList<ArrayList<Integer>> films){
		int featureNum = films.get(0).size();
		ArrayList<Double> preference = new ArrayList<Double>(films.get(0).size());
		ArrayList<Double> scores = new ArrayList<Double>(films.get(0).size());
		
			
		//compute the average rate
		double ave=0;
		int count=0;
		for(int i=0;i<rate.size();++i){
			if(rate.get(i)>0){
				ave+=rate.get(i);
				++count;
			}
		}
		ave = ave*1.0/count;
			
		double sum = 0;
		for(int i=0;i<featureNum;++i){
			count = 0;
			sum = 0;
			for(int j=0;j<rate.size();++j){
				if(rate.get(j)>0&&films.get(j).get(i)==1){
					sum += (rate.get(j)-ave);
					++count;
				}
			}
			//System.out.println("sum\\count is "+sum+" "+count);
			if(count == 0){
				preference.add(0.0);
			}else{
				preference.add(sum/count);
			}
		}
		
		for(int i=0;i<films.size();++i){
			ArrayList<Integer> temp = films.get(i);
//			for(Integer p:temp){
//				System.out.print(p);
//			}
			double score = 0;
			for(int j=0;j<temp.size();++j){
				score += temp.get(j)*preference.get(j);
			}
			scores.add(score);
		}
		
		return scores;
	}

}
