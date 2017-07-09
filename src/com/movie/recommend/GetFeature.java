package com.movie.recommend;

//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.ObjectOutputStream;
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.Arrays;

public class GetFeature {
	
//	private static String classpath = this.getClass().getResource("/").getPath().replaceFirst("/", "");
	private static String relativelyPath="";
	public static String filmFile = relativelyPath+"/assets/filmArray.dat";
	public static String featureFile = relativelyPath+"/Movies/assets/featureArray.dat";
	
	/*
	public static void genFeature(){
		
		String url = "jdbc:mysql://118.89.114.30:3306/movie";
		try{
          //调用Class.forName()方法加载驱动程序
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("成功加载MySQL驱动！");
      }catch(ClassNotFoundException e1){
          System.out.println("找不到MySQL驱动!");
          e1.printStackTrace();
      }
		
		Connection conn;
		ArrayList<String> allTypes = new ArrayList<>();
		ArrayList<String> allFilms = new ArrayList<>();
		ArrayList<String> ids = new ArrayList<>();
		ArrayList<ArrayList<Integer>> films = new ArrayList<ArrayList<Integer>>();
		int[][] feature;
		
		try {
          conn = DriverManager.getConnection(url,"root","0224");
          //创建一个Statement对象
          Statement stmt = conn.createStatement(); //创建Statement对象
          System.out.println("成功连接到数据库！");
          String type = "select distinct tag from douban_movie_tag;";
          ResultSet rs = stmt.executeQuery(type);
          while(rs.next()){
          	allTypes.add(rs.getString(1));
          }
          
          String film = "select movieName,movieId from douban_movie;";
          rs = stmt.executeQuery(film);
          while(rs.next()){
          	allFilms.add(rs.getString(1));
          	ids.add(rs.getString(2));
          }
          
//          for(String s:ids){
//          	System.out.println(s);
//          }
          
          feature = new int[allFilms.size()][allTypes.size()];
          
          String filmtype = "select * from douban_movie_tag;";
          rs = stmt.executeQuery(filmtype);
          while(rs.next()){
          	String id = rs.getString(1);
          	String ty = rs.getString(2);
          	int f_idx = ids.indexOf(id);
          	int t_idx = allTypes.indexOf(ty);
          	feature[f_idx][t_idx] = 1;
          }
          
//          for(int i=0;i<feature.length;++i){
//          	System.out.print(allFilms.get(i)+" ");
//          	for(int j=0;j<feature[0].length;++j){
//          		if(feature[i][j]==1){
//          			System.out.print(allTypes.get(j)+" ");
//          		}
//          		
//          	}
//          	System.out.println();
//          }
          
          stmt.close();
          conn.close();
          
          for(int i=0;i<allFilms.size();++i){
          	films.add(new ArrayList<Integer>());
          	for(int j=0;j<allTypes.size();++j){
          		films.get(i).add(feature[i][j]);
          	}
          }   
          
//          for(int i=0;i<allFilms.size();++i){
//          	//films.add(new ArrayList<Integer>());
//          	System.out.print(allFilms.get(i));
//          	for(int j=0;j<allTypes.size();++j){
//          		if(films.get(i).get(j)==1){
//          			System.out.print(allTypes.get(j)+" ");
//          		}
//          	}
//          	System.out.println();
//          }  
          
          
          FileOutputStream f = new FileOutputStream(filmFile);
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(allFilms);
			f = new FileOutputStream(featureFile);
			o = new ObjectOutputStream(f);
			o.writeObject(films);
			o.close();	
      } catch (SQLException | IOException e){
          e.printStackTrace();
      }
		
	}
	*/
	
}
