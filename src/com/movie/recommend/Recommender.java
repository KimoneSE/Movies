package com.movie.recommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Recommender {
	
	private Algo algo;
	private ArrayList<ArrayList<Integer>> films;
	private ArrayList<String> allFilms;
	
	public Recommender(Algo algo){
		this.algo = algo;
	}
	
	public void setFilms(ArrayList<ArrayList<Integer>> films){
		this.films = films;
	}
	
	public void setAllFilms(ArrayList<String> allFilms){
		this.allFilms = allFilms;
	}
	
	/**
	 * 获取k部推荐
	 * @param user_id 用户id
	 * @param k，电影数目
	 * @return 电影名称
	 */
	public ArrayList<String> getRec_k(HashMap<String,Integer> map,int k){
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<String> re = new ArrayList<>();
		for(int i=0;i<allFilms.size();++i){
			Integer t =0;
			if((t=map.get(allFilms.get(i)))==null){
				arr.add(0);
			}else{
				arr.add(t);
			}
		}
		ArrayList<Double> d = algo.contentRec(arr, this.films);
		//d.sort((Double a,Double b)->{return (a>b)?1:0;});
//		for(int i=0;i<k;++i){
//			re.add(allFilms.))
//		}
//		System.out.println(d.size());
//		
//		for(int i=0;i<arr.size();++i){
//			System.out.print(arr.get(i)+" ");
//		}
//		System.out.println();
		
		Set<String> keyset = map.keySet();
		
		for(int i=0;i<k;++i){
			int idx=0;
			for(int j=0;j<d.size();++j){
				if(d.get(j)>d.get(idx)&&(re.indexOf(allFilms.get(j))==-1)&&!keyset.contains(allFilms.get(j))){
					idx = j;
				}
			}
			re.add(allFilms.get(idx));
		}
		
		return re;
	}
}

