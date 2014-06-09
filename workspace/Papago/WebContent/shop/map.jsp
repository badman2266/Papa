<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<link rel="shortcut icon" href="../images/papago.ico" type="image/x-icon" />
<style type="text/css">
.map {
	width: 100%;
	height: 300px
}
</style>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<link href="../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
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
	$(document)
			.ready(
					function() {
						var m1 = $('#m1');
						m1.tinyMap({
							center : '捷運大安站',
							zoom : 14
						});

						window
								.setTimeout(
										function() {

											$.getJSON("<c:url value='/ShopListDisplay.json'/>",
															function(resp) {
																m1.tinyMap(
																				'modify',
																				{
																					zoom : 14,
																					marker : resp
																				});
															})
										}, 1000);
					});
</script>
</head>
<body>
	<!-- body container -->
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.jsp">美食趴趴Go評價網</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">${user.account}${user.memType.memType}<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="../account/password.jsp">更改密碼</a></li>
						<c:set value="${user.memType.memtypeId}" var="admin"></c:set>
						<c:if test="${admin==2}">
							<li><a href="../admin/inform/news.jsp" target="_blank">管理頁面</a></li>
						</c:if>
						<li class="divider"></li>
						<li><a href="<c:url value='/login/logout.action'/>">登出</a></li>
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
				<li><a href="search.jsp">商家搜尋</a></li>
				<li class="active"><a href="#">地圖搜尋</a></li>
				<!-- <li><a href="../rank/rank.jsp">商家排行</a></li>-->
				<li><a href="../recommend/recommend.jsp">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		<h4 class="text-success">地圖搜尋</h4>
	</div>
	<!-- / body container -->
	<div class="container">
		<div class="map" id="m1"></div>
	</div>
	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; Copyright 2013-2014 PaPaGo 美食團隊</p>
	</div>
	</footer>
	<!--end of footer -->

</body>
</html>