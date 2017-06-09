<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.movie.model.ReleaseMovie" %>
<html>
<head>
	<title>Movies</title>
	<link rel="stylesheet" href="../assets/css/bootstrap.css">
	<link rel="stylesheet" href="../assets/css/custom.css">
</head>

<body style="margin-top:10px">
	<div class="col-xs-offset-2 col-xs-8" id="myContent" style="min-height: 40px">
		<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
           	<li id="release" class="active"><a href="#releasing" data-toggle="tab">正在热映</a></li>
      	    <li id="all"><a href="#allMovies" data-toggle="tab">全部影片</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="releasing">
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