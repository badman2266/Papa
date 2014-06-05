<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首頁</title>
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
<link href="css/website.css" rel="stylesheet" media="screen">
<style type="text/css">
</style>
<script src="http://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">美食趴趴Go評價網 </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<c:if test="${empty user}">
					<form class="navbar-form pull-right">
						<button class="btn btn-success" type="button" role="button"
							onclick="javascript:location.href='login/login.jsp'">會員登入</button>
					</form>
				</c:if>
				<c:if test="${not empty user}">
					<!-- 會員 -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">${user.account}${user.memType.memType}<b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="account/password.jsp">更改密碼</a></li>
							<c:set value="${user.memType.memtypeId}" var="admin"></c:set>
							<c:if test="${admin==2}" >
							<li><a href="admin/inform/news.jsp" target="_blank">管理頁面</a></li>
							</c:if>
							<li class="divider"></li>
							<li><a href="<c:url value='/login/logout.action'/>">登出</a></li>
						</ul></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- Carousel
    ================================================== -->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<img
						data-src="holder.js/960x720/auto/#777:#7a7a7a/text:First slide"
						alt="First slide" src="images/cover1.jpg">
					<div class="container">
						<div class="carousel-caption">
							<h1>
								<i class="glyphicon glyphicon-cutlery"></i>&nbsp選擇喜愛的餐廳類型
							</h1>
							<h3>提供使用者查詢區域性店家餐廳</h3>
							<p>
								<c:if test="${not empty user}">
									<a class="btn btn-lg btn-primary" href="shop/search.jsp"
										role="button">進入搜尋頁面 &raquo;</a>
								</c:if>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img
						data-src="holder.js/960x720/auto/#666:#6a6a6a/text:Second slide"
						alt="Second slide" src="images/cover2.jpg">
					<div class="container">
						<div class="carousel-caption">
							<h1>
								<i class="glyphicon glyphicon-thumbs-up"></i>&nbsp推薦自己喜愛的餐廳
							</h1>
							<h3>讓內部員工給予店家評價，店家的討論</h3>
							<p>
								<c:if test="${not empty user}">
									<a class="btn btn-lg btn-primary"
										href="recommend/recommend.jsp" role="button">進入店家推薦
										&raquo;</a>
								</c:if>
							</p>
						</div>
					</div>
				</div>
				<div class="item">
					<img
						data-src="holder.js/960x720/auto/#555:#5a5a5a/text:Third slide"
						alt="Third slide" src="images/cover3.jpg">
					<div class="container">
						<div class="carousel-caption">
							<h1>
								<i class="glyphicon glyphicon-map-marker"></i>&nbsp地圖餐廳搜尋
							</h1>
							<h3>提供店家餐廳地圖位置查詢</h3>
							<p>
								<c:if test="${not empty user}">
									<a class="btn btn-lg btn-primary" href="shop/map.jsp"
										role="button">進入地圖店家推薦 &raquo;</a>
								</c:if>
							</p>
						</div>
					</div>
				</div>
			</div>
			<a class="left carousel-control" href="#myCarousel" data-slide="prev"><span
				class="glyphicon glyphicon-chevron-left"></span></a> <a
				class="right carousel-control" href="#myCarousel" data-slide="next"><span
				class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
		<!-- /.carousel -->
	</div>
</body>
</html>