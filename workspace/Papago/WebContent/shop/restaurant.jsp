<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="com.cecj03.papago.misc.BoundleMessage_zh_TW" var="message" /><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<style type="text/css">
.map {
	width: 300px;
	height: 300px
}
</style>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
<link href="../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- Include Google Maps API (Google Maps API v3 已不需使用 API Key) -->
<script
	src="http://maps.google.com/maps/api/js?sensor=false&amp;language=zh-TW"></script>
<!-- Require jQuery v1.7.0 or newer -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../js/jquery.tinyMap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
		var addr=$('span#address').html();
		$('.map').tinyMap({
			center :  addr,
			zoom : 15,
			marker : [ {
				addr : addr,
				text : addr,
			} ]
		});
	});
</script>
</head>
<body>
	<!-- body container -->
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">美食趴趴Go評價網</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">會員<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">會員設定</a></li>
						<li><a href="#">更改密碼</a></li>
						<li class="divider"></li>
						<li><a href="#">登出</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<!-- header  -->
	<div class="container">
		<div class="page-header">
			<h1>
				美食趴趴Go評價網 <small>今天想吃什麼？</small>
			</h1>
		</div>
	</div>
	<!-- end of header  -->
	<!-- container-body -->
	<div class="container">
		<!-- container-subnavbar -->
		<div class="container">
			<nav class="navbar" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<!-- <li><a href="#">最新消息</a></li> -->
				<li class="active"><a href="search.jsp">店家搜尋</a></li>
				<li><a href="map.jsp">地圖搜尋</a></li>
				<li><a href="../rank/rank.jsp">店家排行</a></li>
				<li><a href="../recommend/recommend.jsp">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		
		<div class="container">
			<ul class="breadcrumb" style="margin-bottom: 5px; font-size: 18pX;">
				<li><a href="search.jsp">美食趴趴Go評價網</a></li>
				<c:if test="${not empty select}">
					<c:forEach var="bean" items="${select}" >
						<li><a href="#">${bean.shopType.shopType}</a></li>
						<li class="active">${bean.name}</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>
				
		<div class="map" id="m1"></div>
		
		<div class="col-md-8">
			<c:if test="${not empty select}">
				<div class="container">
				<table class="table table-hover">
					<c:forEach var="bean" items="${select}" >
						<tr>
							<td>
								<strong><font size="4">${bean.name}</font></strong>
									<figure style="float: right;">
										<c:if test="${not empty bean.shopPic}">
											<img src="${bean.shopPic}" width="100" border="0">
										</c:if>
									</figure><br>
								類型：${bean.shopType.shopType}　店家狀態：${bean.shopStatusType.shopStatus}<br>
								地址：<span id="address">${bean.shopAddress}</span><br>
								電子信箱：${bean.email}<br>
 								<c:if test="${not empty bean.web}">
 									官方網站：<a href="${bean.web}" target="_blank">有</a><br>
 								</c:if>
 								電話：${bean.phone}<br>
								價格：${bean.price}　價位區間：${bean.priceType.priceType}<br>
								<c:if test="${not empty bean.note}">
									<blockquote>店家備註<br>
										${bean.note}<br>
									</blockquote>
								</c:if>
							</td>
						</tr>
						
						<tr>
							<td>
								<c:if test="${not empty bean.contactName}">聯絡人：${bean.contactName}　聯絡人電話：${bean.contactPhone}<br></c:if>
								<div align="right">
									最後更新日期：${bean.shopDate}<br>
									<a href="" target="_blank" class="smalla">店家資料錯誤回報</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</table>
				</div>
			</c:if>
			
			<!-- 這裡以下是顯示留言區 -->
<%-- 			<c:if test="${not empty select}"> --%>
<!-- 				<div class="container"> -->
<!-- 				<table class="table table-hover"> -->
<%-- 					<c:forEach var="bean" items="${select}" > --%>
<!-- 						<tr> -->
<!-- 							<td> -->
<%-- 								<strong><font size="4">${bean.name}</font></strong> --%>
<!-- 									<figure style="float: right;"> -->
<%-- 										<c:if test="${not empty bean.shopPic}"> --%>
<%-- 											<img src="${bean.shopPic}" width="100" border="0"> --%>
<%-- 										</c:if> --%>
<!-- 									</figure><br> -->
<%-- 								類型：${bean.shopType.shopType}　店家狀態：${bean.shopStatusType.shopStatus}<br> --%>
<%-- 								地址：<span id="address">${bean.shopAddress}</span><br> --%>
<%-- 								電子信箱：${bean.email}<br> --%>
<%--  								<c:if test="${not empty bean.web}"> --%>
<%--  									官方網站：<a href="${bean.web}" target="_blank">有</a><br> --%>
<%--  								</c:if> --%>
<%--  								電話：${bean.phone}<br> --%>
<%-- 								價格：${bean.price}　價位區間：${bean.priceType.priceType}<br> --%>
<%-- 								<c:if test="${not empty bean.note}"> --%>
<!-- 									<blockquote>店家備註<br> -->
<%-- 										${bean.note}<br> --%>
<!-- 									</blockquote> -->
<%-- 								</c:if> --%>
<!-- 							</td> -->
<!-- 						</tr> -->
						
<!-- 						<tr> -->
<!-- 							<td> -->
<%-- 								<c:if test="${not empty bean.contactName}">聯絡人：${bean.contactName}　聯絡人電話：${bean.contactPhone}<br></c:if> --%>
<!-- 								<div align="right"> -->
<%-- 									最後更新日期：${bean.shopDate}<br> --%>
<!-- 									<a href="guest.php?do=report&amp;rsn=269" target="_blank" class="smalla">店家資料錯誤回報</a> -->
<!-- 								</div> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<%-- 					</c:forEach> --%>
<!-- 				</table> -->
<!-- 				</div> -->
				
<!-- 				<ul class="pagination"> -->
			
<%-- 				<c:if test="${pageNo > 1}"> --%>
<%-- 					<li><a href="list.do?pageNo=${pageNo-1}">«</a></li> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${pageNo <= 1}"> --%>
<!-- 					<li class="disabled">«</li> -->
<%-- 				</c:if> --%>
				
<%-- 				<c:forEach items="${pages}" var="page"> --%>
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${page == pageNo}"> --%>
<%-- 							<li class="active"><a href="list.do?pageNo=${page}">${page}</a></li> --%>
<%-- 						</c:when> --%>
						
<%-- 						<c:otherwise> --%>
<%-- 							<li><a href="list.do?pageNo=${page}">${page}</a></li> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
<%-- 				</c:forEach> --%>
				
<%-- 				<c:if test="${pageNo < totalPages}"> --%>
<%-- 					<a href="list.do?pageNo=${pageNo+1}">»</a> --%>
<%-- 				</c:if> --%>
				
<%-- 				<c:if test="${pageNo < totalPages}"> --%>
<%-- 					<li><a href="list.do?pageNo=${pageNo+1}">»</a></li> --%>
<%-- 				</c:if> --%>
<%-- 				<c:if test="${pageNo >= totalPages}"> --%>
<!-- 					<li class="disabled">»</li> -->
<%-- 				</c:if> --%>
<!-- 			</ul> -->
				
<%-- 			</c:if> --%>
		</div>


	</div>
	<!-- / body container -->

	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; Copyright 2013-2014 PaPaGo 美食團隊</p>
	</div>
	</footer>
	<!--end of footer -->

</body>
</html>