package com.movie.recommend;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class Starter {
	
	private static Recommender rec;
	private static boolean tag = false;
	
	public static void initialize(){
		if(!tag){
			tag = true;
			rec = new Recommender(new RecommendAlgo());
			try {
				FileInputStream f = new FileInputStream(GetFeature.featureFile);
				ObjectInputStream i = new ObjectInputStream(f);
				ArrayList<ArrayList<Integer>> films = (ArrayList<ArrayList<Integer>>)i.readObject();
				rec.setFilms(films);
				
				f = new FileInputStream(GetFeature.filmFile);
				i = new ObjectInputStream(f);
				ArrayList<String> arr = (ArrayList<String>)i.readObject();
				rec.setAllFilms(arr);
				
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static ArrayList<String> getRec_k(HashMap<String,Integer> map,int k){
		return rec.getRec_k(map,k);
		
	}
}
