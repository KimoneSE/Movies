<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
<title>用户注册</title>
<link rel="stylesheet" href="../assets/css/bootstrap.css">
<link rel="stylesheet" href="../assets/css/mv.css">

<style>
.myPanel {
	margin-top: 15%;
}
</style>
</head>
<body id="myBody">
	<div class="navbar navbar-default" id="myNav">
    	<div class="navbar-header">
        	<a class="navbar-brand" id="hw" href="http://localhost:8080/Movies/views/index.jsp">iMovie</a>
        </div>
    </div>
    
	<div class="container">
		<div class="col-sm-offset-4 col-sm-4 myPanel">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title text-center" id="title">iMovie用户注册</h3>
				</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-sm-offset-1 col-sm-10">
						<form class="register_form">
							<div class="form-group">
								<input class="input_login form-control" type="text" name="username"
									placeholder="请输入用户名" />
							</div>
							<div class="form-group">
								<input class="input_password form-control" type="password"
									name="password" placeholder="请输入密码" />
							</div>
							<div class="form-group">
								<button type="button" class="btn btn-block btn-success"
									onclick="register()">注册</button>
							</div>
							<%@include file="/views/common/tip.jsp"%>
						</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>



<script src="${pageContext.request.contextPath}/assets/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/myscript.js"></script>

<script>
	$(document).ready(function() {

	});
	function register() {
		$.ajax({
			type : "POST",
			url : "http://localhost:8080/Movies/user/register",
			data : $('.register_form').serialize(),
			success : function(data) {
				//alert(data["success"]);
				if (data["success"] == false) {
					showTip(data["tip"]);
					$(".input_password").val("");
				} else if (data["success"] == true) {
					showTip("注册成功");
					setTimeout(function () {
                        window.location.href = "http://localhost:8080/Movies/user/login";
                    }, 3000);
					
				}
			},
			error : function() {
				showTip("连接错误，请稍后再试");
			}
		})
	}
</script>
</html>