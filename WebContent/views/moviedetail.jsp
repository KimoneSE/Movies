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
	<%Map detail = (Map)request.getAttribute("detail"); %>
		<div style="">
		<div><%=detail.get("name") %></div>
		<div>
		<img src="<%=detail.get("img") %>"/>
		</div>
		<div>
		<div>制片国家/地区：<span><%=detail.get("region") %></span></div>
		<div>时长：<span><%=detail.get("duration") %></span></div>
		<div>上映日期：<span><%=detail.get("releaseTime") %></span></div>
		</div>
		</div>

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