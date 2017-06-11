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
	<style type="text/css">
		.number{
       		font-size:18px;
			color: #ff8000;	
			margin-top:10px;
       	}
       	.word{
       		font-size:16px;
       		margin-top:10px;
       	}
       	.panel-bottom-border {
    		border-bottom: solid 1px #e0e0e0;
    		cursor: HAND;
		}
		.panel-top-border {
    		border-top: solid 1px #e0e0e0;
		}
		#cinema_name,#price{
			font-size:16px;
			margin-bottom:5px;
		}
		#address{
			color:grey;
			margin-bottom:5px;
		}
	</style>
</head>
<body>

	<div>
		<%
			Map detail = (Map) request.getAttribute("detail");
		%>
		<div style="margin-left: 5%; margin-top: 10px;">
			<h4>
				<b>影片详情</b>
			</h4>
		</div>
		<div class="col-xs-offset-1 col-xs-10">

			<div class="row" style="margin-top: 10px; margin-bottom: 20px;">
				<div class="col-xs-2">
					<img style="width: 180px; height: 250px;"
						src="<%=detail.get("img")%>" />
				</div>
				<div class="col-xs-10">
					<div>
						<h4>
							<b><%=detail.get("name")%></b>
						</h4>
					</div>
					<div class="number"><%=detail.get("score")%>分
					</div>
					<%
					List directors = (List)detail.get("directors");
					List actors = (List)detail.get("actors");
					%>
					<div class="word">导演：<span>
					<%
					for(int di = 0;di<directors.size();di++){
						Director d = (Director)directors.get(di);
						out.print(d.getDirectorName());
						if(di<directors.size()-1){
							out.print("/");
						}
					}
					%>
					</span></div>
					<div class="word">主演：<span>
					<%
					for(int ai = 0;ai<actors.size();ai++){
						Actor a = (Actor)actors.get(ai);
						out.print(a.getActorName());
						if(ai<actors.size()-1){
							out.print("/");
						}
					}
					%>
					</span></div>
					<div class="word">
						制片国家/地区：<span><%=detail.get("region")%></span>
					</div>
					<div class="word">
						时长：<span><%=detail.get("duration")%></span>
					</div>
					<div class="word">
						上映日期：<span><%=detail.get("releaseTime")%></span>
					</div>
					<%
					if(detail.get("downloadlink")!=null){
						out.println("<div class=\"word\">"
								+"下载链接：<span>"+detail.get("downloadlink")
								+"</span></div>");
					}
					%>
					
				</div>
			</div>

		<div id="myContent"
			style="min-height: 40px; width: 80%; margin-top: 30px;">
			<ul class="nav nav-tabs" id="selectTab" style="font-family: 等线">
				<li id="intro" class="active"><a href="#introduction"
					data-toggle="tab">简介</a></li>
				<li id="comm"><a href="#comment" data-toggle="tab">评价</a></li>
				<li id="pri"><a href="#price" data-toggle="tab">票价</a></li>

			</ul>
			<div id="myTabContent" class="tab-content">

				<div class="tab-pane fade in active" id="introduction">
					<div style="margin-top: 4%; width: 85%;margin-left:5%;margin-right:5%;font-size:17px;">
						<p><%=detail.get("introduction")%></p>
					</div>
				</div>

				<div class="tab-pane fade" id="comment">
					<div style="margin-top: 4%; width: 100%;">
						<%
							List comments = (List) request.getAttribute("comments");

							for (int k = 0; k < comments.size(); k++) {
								Comment c = (Comment) comments.get(k);
								out.println(
										"<div style=\"border-bottom: 1px solid lightgray;margin-left: 5%;padding-top:10px;padding-bottom: 8px;width:90%;\">"
												+ "<span style=\"color: #5bc0de;font-size: 16px;\">" + c.getUsername() + "</span>"
												+ "<span style=\"color: darkgray;display: inline-block;margin-left: 3%;font-size: 15px;\">"
												+ c.getTime() + "</span><br><div style=\"margin-top:3px;\">"
												+ "<span style=\"display: inline-block;font-size: 18px;\">" + c.getComment() + "</span>"
												+ "<span style=\"color: palevioletred;display: inline-block;margin-right: 3%;float:right;font-size: 20px;\">"
												+ c.getScore() + "</span></div></div>");
							}
						%>

					</div>
				</div>
				<div class="tab-pane fade" id="price">
					<div style="margin-top: 10px; width: 100%;">
					<%
					for(int i = 0;i<3;i++){
						out.println("<div class=\"panel panel-bottom-border\" onclick=showDetail(1,'"+i+"')>"
								+"<div class=\"row\">"
										+"<div class=\"col-xs-2\" id=\"cinema_name\">南京新街口影城</div>"
										+"<div class=\"col-xs-10\" id=\"price\">"+"39-40元"+"</div>"
										+"</div>"
										+"<div id=\"address\">杨将军巷9号曼度文化广场3楼（太平北路1912对面）</div>"
					//id改为每个电影院的名称 
					+"<div id="+i+"></div>"
					+"</div>");
					}
					%>
						
				</div>
			</div>
		</div>

		</div>
	</div>

<script src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
</body>

<script>
	var map = new Map();
	$(document).ready(function(){
		var list=['0','1','2'];
		init(list);
	});

	
	function init(cinemaNameList){
		for(var i=0;i<cinemaNameList.length;i++){
			map[cinemaNameList[i]]=0;
		}
	}
	
	function showDetail(cinema_id,movie_name){
		$("#"+movie_name).empty();
		for(i=0;i<3;i++){
			if(map[movie_name]%2==0){
				var temp="<div class=\"panel panel-top-border\"><div class=\"row\"><div class=\"col-xs-3\">场次时间</div><div class=\"col-xs-9\"><a href=\"\">去订票</a></div></div></div>"
				$("#"+movie_name).append(temp);
			}
		}
		map[movie_name]++;
	}
</script>
</html>