<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>查詢回報店家資訊</title>
<link rel="shortcut icon" href="../../images/papago.ico" type="image/x-icon" />
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../../css/bootstrap-datetimepicker.css" rel="stylesheet"
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
			<a class="navbar-brand" href="../inform/news.jsp">美食趴趴Go評價網 管理員系統</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<!-- 管理員 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">${user.account}管理員<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="../../index.jsp"  target="_blank">網站首頁</a></li>
						<li><a href="../inform/news.jsp">管理員頁面</a></li>
						<li class="divider"></li>
						<li><a href="<c:url value='/login/logout.action'/>">登出</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<div class="container">
		<div class="page-header">
			<h1>
				美食趴趴Go評價網 <small>管理系統</small>
			</h1>
		</div>
	</div>
	<!-- container-body 要寫在裡面-->
	<div class="container">
		<!-- container-subnavbar -->
		<div class="container">
			<nav class="navbar" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<li><a href="../inform/news.jsp">主頁面</a></li>
				<li><a href="#">會員系統</a></li>
				<li class="active"><a href="Insert_shop.jsp">商家系統</a></li>
			</ul>
			</nav>
		</div>
		<!--end of subnavbar -->
		
		<!-- subbar list 看自己需不需要-->
		<div class="col-sm-3">
			<ul class="nav nav-stacked nav-pills">
				<li class="active text-success"><a href="#"
					style="text-align: center">商家系統</a></li>
				<li><a href="Insert_shop.jsp">新增店家</a></li>
				<li><a href="RUD_shop.jsp">查詢及刪除修改店家</a></li>
				<li><a href="PriceType.jsp">價位類型表單</a></li>
			</ul>
		</div>
		<!--end of subbar list -->
		<div class="container col-sm-9">
			<legend>顯示回報店家資料</legend>
			<c:if test="${not empty select}">
				<div class="table-responsive">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>回報ID</th>
								<th>店家ID</th>
								<th>店家名稱</th>
								<th>會員ID</th>
								<th>會員帳號</th>
								<th>回報時間</th>
								<th>回報內容</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bean" items="${select}">
								<tr>
									<td>${bean.updateId}</td>
									<td>${bean.papaShop.shopId}</td>
									<td>${bean.papaShop.name}</td>
									<td>${bean.papaMem.memId}</td>
									<td>${bean.papaMem.account}</td>
									<td>${bean.updateDate}</td>
									<td>${bean.updateContent}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:if>
		</div>
	</div>
	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; PaPaGo Team</p>
	</div>
	</footer>
	<!--end of footer -->

</body>
</html>