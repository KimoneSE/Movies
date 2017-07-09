package com.movie.recommend;

import java.util.ArrayList;
import java.util.HashMap;

public class Test {
	public static void main(String[] args){
		Starter.initialize("E:\\Download");
		System.out.println("success.");
		HashMap<String,Integer> map = new HashMap<>();
		map.put("杰出公民", 4);
		map.put("三人行", 5);
		map.put("28岁未成年", 3);
		map.put("一种谋杀", 4);
		map.put("京城81号Ⅱ", 5);
		
		ArrayList<String> arr = Starter.getRec_k(map, 7);
		for(String s:arr){
			System.out.println(s);
		}
	}
}
