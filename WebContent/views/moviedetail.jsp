<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<title>Movies</title>
<link rel="stylesheet"
	href="<%=response.encodeURL(request.getContextPath() + "/assets/css/bootstrap.css")%>">
<link rel="stylesheet"
	href="<%=response.encodeURL(request.getContextPath() + "/assets/css/custom.css")%>">
</head>
<body>

	<div>
		<div style=""></div>

		<div id="myContent"
			style="min-height: 40px; width: 80%; margin-top: 30px; margin-left: 5%;">
			<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">			
				<li id="comm" class="active"><a href="#comment" data-toggle="tab">评价</a></li>
				<li id="pri"><a href="#price" data-toggle="tab">票价</a></li>
				<li id="download"><a href="#downloadlink" data-toggle="tab">下载链接</a></li>
			</ul>
			<div id="myTabContent" class="tab-content">			

				<div class="tab-pane fade in active" id="comment">
					<div style="margin-top: 4%; width: 100%;"></div>
				</div>

				<div class="tab-pane fade" id="price">
					<div style="margin-top: 4%; width: 100%;"></div>
				</div>
				
				<div class="tab-pane fade" id="downloadlink">
					<div style="margin-top: 4%; width: 100%;"></div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>