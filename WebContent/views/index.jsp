<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>iMovie</title>
	<link rel="stylesheet" href="../assets/css/bootstrap.css">
	<link rel="stylesheet" href="../assets/css/mv.css">
	
	<style>
		.index{
			margin-top: 15%;
		}
		.tbtn{margin-top: 5%;}
	</style>
</head>

<body id="myBody">
	<div class="navbar navbar-default" id="myNav">
    	<div class="navbar-header">
        	<a class="navbar-brand" id="hw" href="http://localhost:8080/Movies/views/index.jsp">iMovie</a>
        </div>
    </div>
    
	<div class="container">
		<div class="col-sm-offset-4 col-sm-3 index">
			<div class="form-group">
				<a href="${pageContext.request.contextPath }/user/login" class="btn btn-block btn-info tbtn">登录</a>
			</div>
			<div class="form-group">
				<a href="${pageContext.request.contextPath }/user/register" class="btn btn-block btn-success tbtn">>注册</a>
			</div>
		</div>
	</div>
	
	<script src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
</body>
</html>