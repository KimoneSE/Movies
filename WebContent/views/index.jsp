<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Movies</title>
	<link rel="stylesheet" href="../assets/css/bootstrap.css">
</head>

<body style="margin-top:10px">
	<div class="col-xs-offset-2 col-xs-8" id="myContent" style="min-height: 40px">
		<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
           	<li id="release" class="active"><a href="#releasing" data-toggle="tab">正在热映</a></li>
      	    <li id="all"><a href="#allMovies" data-toggle="tab">全部影片</a></li>
        </ul>
        <div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="releasing">
					
					
				</div>
				<div class="tab-pane fade" id="allMovies">
					
					
				</div>
			</div>
		</div>
	<script src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
</body>
</html>