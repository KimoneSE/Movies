<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.movie.model.*" %>
<%@ page import="java.util.*" %>
<html>
<head>
	<title>Movies</title>
	<link rel="stylesheet" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/bootstrap.css") %>">
	<link rel="stylesheet" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/custom.css") %>">
	<style>
		.panel-top-border {
    		border-top: solid 1px #e0e0e0;
		}	
		.inline-title {
    		display: inline;
		}
	</style>
</head>

<body>
<%@include file="common/userNavbar.jsp" %>
<div class="row">
	<div class="col-xs-2">
	<div class="panel rank-panel" style="margin-left:10%;margin-top:30px;">
		<div class="panel-heading">
        	<h4 class="inline-title">排行榜</h4>
        </div>
        <div class="panel-body panel-top-border">
        	<%
		 	List rank = (List)request.getAttribute("rank");
        	int len = rank.size();
        	if(len>10)
        		len = 10;
			for(int i=0;i<len;i++){
				Movie rk =  (Movie)rank.get(i);
				String movieName = rk.getMovieName();
				int j=i+1;
				out.println("<div class=\"panel\" style=\"margin-left:3%\"><i>"+j+"</i>&nbsp;&nbsp;"+movieName.substring(0,movieName.length())+"</div>");
			}
			%>
        </div>
	</div>
		
	</div>
	<div class="col-xs-7">
	
	<div id="myContent" style="min-height: 40px;width:80%;margin-top:30px;margin-left:1%;padding:0;">
		<!--<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
           	<li id="release" class="active"><a href="#releasing" data-toggle="tab">正在热映</a></li>-->
           	<!-- <li id="coming"><a href="#comingMovies" data-toggle="tab">即将上映</a></li> -->
      	    <!-- <li id="all"><a href="#allMovies" data-toggle="tab">全部影片</a></li> -->
       <!-- </ul> -->
        <div id="myTabContent" class="tab-content">
				<!--<div class="tab-pane fade in active" id="releasing"> -->
					<div style="margin-top: 4%;width:100%;">
        
        <%
        List rlist = (List)request.getAttribute("release");
        for(int i = 0;i<rlist.size();i++){
        	Movie rm = (Movie)rlist.get(i);
        	out.println("<a href=\"http://localhost:8080/Movies/Movie?mname="+rm.getMovieName()+"\" class=\"movieDiv\" style=\"display: inline-block;margin-left: 5px;vertical-align:top;\" "
        	+request.getContextPath()+"/"+""+"\">"
        	+"<div style=\"width:180px;\">"
        	+" <img src='"+rm.getPoster()+"' height=\"180\" width=\"180\"/>"
        	+"<div style=\"font-size: 17px;margin-top: 2%;\">"+rm.getMovieName()
        	+"<span style=\"color:red;font-size: 18px;float:right;\">"+rm.getScore()+"分"+"</span></div>"
        	+" </div> </a>");
        }
        %>

        	<!--</div> -->
					
	</div>
				
	<!-- <div class="tab-pane fade" id="allMovies">
					<div style="margin-top: 4%;width:100%;">
        
        <%
        
       // List alist = (List)request.getAttribute("rlist");
        //for(int i = 0;i<alist.size();i++){
        	//Movie m = (Movie)alist.get(i);
        	
 //       	out.println("<a href=\"http://localhost:8080/Movies/Movie?mname="+m.getMovieName()+"\" class=\"movieDiv\" style=\"display: inline-block;margin-left: 3%;vertical-align:top;\" "
 //       	+request.getContextPath()+"/"+""+"\">"
  //      	+"<div style=\"width:200px;\">"
    //    	+" <img src='"+m.getPoster()+"' height=\"200\" width=\"200\"/>"
      //  	+"<div style=\"font-size: 17px;margin-top: 2%;\">"+m.getMovieName()
        //	+"<span style=\"color:red;font-size: 18px;float:right;\">"+m.getScore()+"分"+"</span></div>"
        	//+" </div> </a>");
        //}
        %>

        </div>
					
				</div> 
		-->
		<!-- 
		<div class="tab-pane fade" id="comingMovies">
					<div style="margin-top: 4%;width:100%;">
        
        <%
        
        //List clist = (List)request.getAttribute("coming");
        //for(int i = 0;i<clist.size();i++){
//        	ComingMovie cm = (ComingMovie)clist.get(i);
        	
 //       	out.println("<a href=\"http://localhost:8080/Movies/Movie?mname="+cm.getMovie()+"\" class=\"movieDiv\" style=\"display: inline-block;margin-left: 3%;vertical-align:top;\" "
  //      	+request.getContextPath()+"/"+""+"\">"
   //     	+"<div style=\"width:200px;\">"
   //     	+" <img src='"+cm.getImg()+"' height=\"200\" width=\"200\"/>"
   //     	+"<div style=\"font-size: 17px;margin-top: 2%;\">"+cm.getMovie()
   //     	+"<span style=\"color:red;font-size: 18px;float:right;\">"+cm.getTime()+"</span></div>"
   //     	+" </div> </a>");
   //     }
        %>

        </div>
				</div>
		 -->
				
			</div>
		</div>	
	</div>
	
	<div class="col-xs-3">
	<div class="panel rank-panel" style="margin-left:2%;margin-top:30px;">
		<div class="panel-heading">
        	<h4 class="inline-title">你可能喜欢</h4>
        </div>
        <div class="panel-body panel-top-border">
        	<%
		 	List recommend = (List)request.getAttribute("recommend");
       
			for(int i=0;i<recommend.size();i++){
				Movie r =  (Movie)recommend.get(i);
				String movieName = r.getMovieName();
				int j=i+1;
				out.println("<a class=\"panel\" style=\"margin-left:3%;height:60px;display:inline-block;\" href='http://localhost:8080/Movies/Movie?mname="+movieName+"'><div><i>"+j
						+"&nbsp;&nbsp;</i><img src='"+r.getPoster()+"' style='width:60px;height:60px;display:inline-block;'/>&nbsp;&nbsp;"+movieName+"</div></a>");
			}
			%>
        </div>
	</div>
		
	</div>
</div>
		
	<script src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
</body>
</html>