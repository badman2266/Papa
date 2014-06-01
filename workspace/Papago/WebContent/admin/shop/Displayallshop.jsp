<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>顯示全部店家</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</head>
<body>
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
			<a class="navbar-brand" href="#">美食趴趴Go評價網 管理員</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- 管理員 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">管理員<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">網站首頁</a></li>
						<li><a href="#">管理員頁面</a></li>
						<li><a href="#">訊息通知</a></li>
						<li class="divider"></li>
						<li><a href="#">登出</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container">
		<div class="page-header">
			<h1>
				美食趴趴Go評價網 <small>今天想吃什麼？</small>
			</h1>
		</div>
	</div>

	<div class="container">
		<!-- container-subnavbar -->
		<div class="container">
			<nav class="navbar" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<!-- <li><a href="#">最新消息</a></li> -->
				<li><a href="#">訊息通知</a></li>
				<li><a href="#">會員系統</a></li>
				<li class="active"><a href="#">商家系統</a></li>
				<li><a href="#">排名系統</a></li>
				<li><a href="#">留言系統</a></li>
			</ul>
			</nav>
		</div>
		<!--end of subnavbar -->

		<!-- subbar list 看自己需不需要-->
		<div class="col-sm-3">
			<ul class="nav nav-stacked nav-pills">
				<li class="active text-success"><a href="#" style="text-align:center">商家系統</a></li>
				<li><a href="Insert_shop.jsp">新增店家</a></li>
				<li><a href="RUD_shop.jsp">查詢及刪除修改店家</a></li>
			</ul>
		</div>
		<div class="container col-sm-9">
			<legend>顯示全部店家</legend>
			<c:if test="${not empty select}">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>店家ID</th>
								<th>店家名稱</th>
								<th>店家價位</th>
								<th>連絡電話</th>
								<th>店家地址</th>
								<th>E-mail</th>
								<th>聯絡人</th>
								<th>聯絡人電話</th>
								<th>網站</th>
								<th>更新日期</th>
								<th>店家型態</th>
								<th>店家價位區間</th>
								<th>店家狀態</th>
								<th>備註</th>
								<th>連結</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${select}">
								<c:url value="RUD_shop.jsp" var="path">
									<c:param name="bean.shopId" value="${bean.shopId}" />
									<c:param name="bean.name" value="${bean.name}" />
									<c:param name="bean.price" value="${bean.price}" />
									<c:param name="bean.phone" value="${bean.phone}" />
									<c:param name="bean.shopAddress" value="${bean.shopAddress}" />
									<c:param name="bean.contactName" value="${bean.contactName}" />
									<c:param name="bean.contactPhone" value="${bean.contactPhone}" />
									<c:param name="bean.web" value="${bean.web}" />
									<c:param name="bean.email" value="${bean.email}" />
									<c:param name="bean.note" value="${bean.note}" />
								</c:url>
								<tr>
									<td>${bean.shopId}</td>
									<td>${bean.name}</td>
									<td>${bean.price}</td>
									<td>${bean.phone}</td>
									<td>${bean.shopAddress}</td>
									<td>${bean.email}</td>
									<td>${bean.contactName}</td>
									<td>${bean.contactPhone}</td>
									<td>${bean.web}</td>
									<td>${bean.shopDate}</td>
									<td>${bean.shopType.shopType}</td>
									<td>${bean.priceType.priceType}</td>
									<td>${bean.shopStatusType.shopStatus}</td>
									<td>${bean.note}</td>
									<td><a href="${path}">修改或刪除</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>
	<footer>
	<div class="container">
		<p class="pull-right">&copy; PaPaGo Team</p>
	</div>
	</footer>
	<!--end of footer -->
</body>
</html>