<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
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
				<li><a href="../shop/search.jsp">店家搜尋</a></li>
				<li><a href="../shop/map.jsp">地圖搜尋</a></li>
				<li><a href="../rank/rank.jsp">店家排行</a></li>
				<li class="active"><a href="#">店家推薦</a></li>
			</ul>
			</nav>
		</div>


	</div>
	<!-- / body container -->
	<div class="container">
		<div class="container">
			<form class="form-horizontal" role="form" method="get">
				<fieldset>
					<legend>推薦店家成功</legend>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">推薦會員ID</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="memId" />
							</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">店家名稱</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.name" />
							</p>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhone" class="col-sm-2 control-label">店家電話</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.phone" />
							</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">店家E-Mail</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.email" />
							</p>

						</div>
					</div>

					<div class="form-group">
						<label for="inputAddr" class="col-sm-2 control-label">店家地址</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.recAddress" />
							</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">價位</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.price" />
							</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">網站</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.web" />
							</p>
						</div>
					</div>


					<div class="form-group">
						<label for="note" class="col-sm-2 control-label">備註</label>
						<div class="col-sm-6">
							<p class="form-control-static">
								<s:property value="bean.note" />
							</p>
						</div>
					</div>

				</fieldset>
			</form>
		</div>
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