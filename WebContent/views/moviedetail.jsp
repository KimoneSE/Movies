<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.movie.model.*"%>
<%@ page import="java.util.*"%>
<%@ page import="net.sf.json.JSONArray"%>
<html>
<head>
<title>Movies</title>
<link rel="stylesheet"
	href="<%=response.encodeURL(request.getContextPath() + "/assets/css/bootstrap.css")%>">
<link rel="stylesheet"
	href="<%=response.encodeURL(request.getContextPath() + "/assets/css/custom.css")%>">
<style type="text/css">
.number {
	font-size: 18px;
	color: #ff8000;
	margin-top: 10px;
}

.word {
	font-size: 16px;
	margin-top: 10px;
}

.panel-bottom-border {
	border-bottom: solid 1px #e0e0e0;
	cursor: HAND;
}

.panel-top-border {
	border-top: solid 1px #e0e0e0;
}

#cinema_name, #price {
	font-size: 16px;
	margin-bottom: 5px;
}

#address {
	color: grey;
	margin-bottom: 5px;
}
</style>
</head>

<%
	Map detail = (Map) request.getAttribute("detail");
	JSONArray cnames = (JSONArray) request.getAttribute("cnames");
%>

<body onload='init(<%=cnames%>)'>
	<%@include file="common/userNavbar.jsp"%>
	<%
		Movie m = (Movie) detail.get("movie");
	%>
	<div>

		<div style="margin-left: 5%; margin-top: 10px;">
			<h4>
				<b>影片详情</b>
			</h4>
		</div>
		<div class="col-xs-offset-1 col-xs-10">

			<div class="row" style="margin-top: 10px; margin-bottom: 20px;">
				<div class="col-xs-2">
					<img style="width: 180px; height: 250px;" src="<%=m.getPoster()%>" />
				</div>
				<div class="col-xs-10">
					<div>
						<h4>
							<b><%=m.getMovieName()%></b>
						</h4>
					</div>
					<div class="number"><%=m.getScore()%>分
					</div>
					<%
						List directors = (List) detail.get("directors");
						List actors = (List) detail.get("actors");
						List tags = (List) detail.get("tags");
					%>
					<div class="word">
						导演：<span> <%
 	for (int di = 0; di < directors.size(); di++) {
 		MovieDirector d = (MovieDirector) directors.get(di);
 		out.print(d.getDirectorName());
 		if (di < directors.size() - 1) {
 			out.print("，");
 		}
 	}
 %>
						</span>
					</div>
					<div class="word">
						主演：<span> <%
 	for (int ai = 0; ai < actors.size(); ai++) {
 		MovieActor a = (MovieActor) actors.get(ai);
 		out.print(a.getActorName());
 		if (ai < actors.size() - 1) {
 			out.print("，");
 		}
 	}
 %>
						</span>
					</div>
					<div class="word">
						制片国家/地区：<span><%=m.getRegion()%></span>
					</div>
					<div class="word">
						类型：<span> <%
 	for (int ti = 0; ti < tags.size(); ti++) {
 		MovieTag t = (MovieTag) tags.get(ti);
 		out.print(t.getTag());
 		if (ti < tags.size() - 1) {
 			out.print("，");
 		}
 	}
 %>
						</span>
					</div>
					<div class="word">
						时长：<span><%=m.getDuring()%></span>
					</div>
					<div class="word">
						上映日期：<span><%=m.getReleaseDate().toString()%></span>
					</div>
					<%
						if (detail.get("boxOffice") != null) {
							out.println("<div class=\"word\">" + "票房：<span>" + detail.get("boxOffice") + "</span></div>");
						}
						//	if (detail.get("downloadlink") != null) {
						//		out.println("<div class=\"word\">" + "下载链接：<span>" + detail.get("downloadlink") + "</span></div>");
						//	}
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
						<div
							style="margin-top: 4%; width: 85%; margin-left: 5%; margin-right: 5%; font-size: 17px;">
							<p><%=m.getSummary()%></p>
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
													+ "<span style=\"color: #5bc0de;font-size: 16px;\">" + c.getCommentator() + "</span>"
													+ "<span style=\"color: darkgray;display: inline-block;margin-left: 3%;font-size: 15px;\">"
													+ c.getCommentTime().toString() + "</span><br><div style=\"margin-top:3px;\">"
													+ "<span style=\"display: inline-block;font-size: 17px;width:82%;\">" + c.getComment()
													+ "</span>"
													+ "<span style=\"color: palevioletred;display: inline-block;margin-right: 3%;width:10%;float:right;font-size: 22px;\">"
													+ c.getCommentLevel() + "</span></div></div>");
								}
							%>

						</div>
					</div>

					<div class="tab-pane fade" id="price">
						<div style="margin-top: 10px; width: 100%;">
						<select id="cinema" onchange="getPrices()">
						<%
						for(int i = 0;i<cnames.size();i++){
							String ci = cnames.get(i).toString();
							out.println("<option value =\""+ci+"\">"+ci+"</option>");
						}
						%>
						</select>
						<div id="priceContent" onload="showPrice()"></div>
							<%
								//List prices = (List) request.getAttribute("prices");
								//for (int i = 0; i < prices.size(); i++) {
								//Map map = (Map) prices.get(i);
								//Cinema c = (Cinema) map.get("cinema");
								//out.println("<div class=\"panel panel-bottom-border\" onclick='showDetail(\"" + c.getName() + "\","
								//	+ map.get("ptime") + ")'>" + "<div class=\"row\">"
								//	+ "<div class=\"col-xs-4\" id=\"cinema_name\">" + c.getName() + "</div>"
								//	+ "<div class=\"col-xs-6\" id=\"price\">" + map.get("price") + "</div>" + "</div>"
								//	+ "<div id=\"address\">" + c.getCity() + c.getAddress() + "</div>"
								//id改为每个电影院的名称 
								//	+ "<div id='" + c.getName() + "'></div>" + "</div>");
								//}
							%>

						</div>
					</div>
				</div>

			</div>

		</div>
	</div>

	<script
		src="${pageContext.request.contextPath }/assets/js/jquery-2.1.4.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/js/bootstrap.js"></script>
</body>

<script>
function getPrices(){
	var obj=document.getElementById("cinema");
	var index=obj.selectedIndex; //序号，取当前选中选项的序号
	var cname = obj.options[index].text;
	
	 $.ajax({
         type: "POST",
         url: "",
         data: {cname:cname},
         dataType: "json",
         success: function(data){
        	 showPrices(data);
                  }
     });
}

function showPrices(data){
	
}
</script>

<script>
	var map = new Map();

	
	function init(cinemaNameList){
		//alert(cinemaNameList);
		for(var i=0;i<cinemaNameList.length;i++){
			//alert("****");
			map[cinemaNameList[i]]=0;
		}
	}

	function showDetail(movie_name,plist){
		 
		$("#"+movie_name).empty();
		//alert(plist[0]);
		for(var i = 0;i<plist.length;i++){
			var p = plist[i];
			if(map[movie_name]%2==0){
				var temp="<div class=\"panel panel-top-border\"><div class=\"row\"><div class=\"col-xs-3\">"+p.time+"</div><div class=\"col-xs-9\"><a href=\""+p.orderLink+"\">去订票</a></div></div></div>";
				$("#"+movie_name).append(temp);
			}
		}
		map[movie_name]++;
	}
</script>
</html>