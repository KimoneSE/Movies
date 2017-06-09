<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.movie.model.ReleaseMovie" %>
<%@ page import="java.util.*" %>
<html>
<head>
	<title>Movies</title>
	<link rel="stylesheet" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/bootstrap.css") %>">
	<link rel="stylesheet" href="<%=response.encodeURL(request.getContextPath()+"/assets/css/custom.css") %>">
</head>

<body style="margin-top:10px">
	<div id="myContent" style="min-height: 40px;width:85%;margin-left:10%;margin-top:30px;">
		<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
           	<li id="release" class="active"><a href="#releasing" data-toggle="tab">正在热映</a></li>
      	    <li id="all"><a href="#allMovies" data-toggle="tab">全部影片</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="releasing">
					<div style="margin-top: 4%;width:100%;">
        
        <%
        List rlist = (List)request.getAttribute("release");
        for(int i = 0;i<rlist.size();i++){
        	ReleaseMovie rm = (ReleaseMovie)rlist.get(i);
        	out.println("<a class=\"movieDiv\" style=\"display: inline-block;margin-left: 3%;vertical-align:top;\" href=\""
        	+request.getContextPath()+"/"+""+"\">"
        	+"<div style=\"width:200px;\">"
        	+" <img src='"+rm.getImg()+"' height=\"200\" width=\"200\"/>"
        	+"<div style=\"font-size: 17px;margin-top: 2%;\">"+rm.getMovieName()
        	+"<span style=\"color:red;font-size: 18px;float:right;\">"+rm.getScore()+"分"+"</span></div>"
        	+" </div> </a>");
        }
        %>

        </div>
					
				</div>
				<div class="tab-pane fade" id="allMovies">
					<div style="margin-top: 4%;width:100%;">
        
        <%
        
        for(int i = 0;i<3;i++){
        	
        	out.println("<a class=\"movieDiv\" style=\"display: inline-block;margin-left: 3%;vertical-align:top;\" href=\""
        	+request.getContextPath()+"/"+""+"\">"
        	+"<div style=\"width:200px;\">"
        	+" <img src='"+1+"' height=\"200\" width=\"200\"/>"
        	+"<div style=\"font-size: 17px;margin-top: 2%;\">"+"加勒比海盗"
        	+"<span style=\"color:red;font-size: 18px;float:right;\">"+"8.0分"+"</span></div>"
        	+" </div> </a>");
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