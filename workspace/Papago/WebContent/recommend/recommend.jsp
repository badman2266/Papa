<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>推薦商家</title>
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
				<li><a href="../shop/search.jsp">店家搜尋</a></li>
				<li><a href="../shop/map.jsp">地圖搜尋</a></li>
				<!-- <li><a href="#">商家排行</a></li>-->
				<li class="active"><a href="#">店家推薦</a></li>
			</ul>
			</nav>
		</div>


	</div>
	<!-- / body container -->
	<div class="container">
		<div class="container">
			<form class="form-horizontal" role="form" method="get"
				action="<c:url value="/recommend/rec.action" />">
				<fieldset>
					<legend>推薦店家</legend>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">推薦會員ID</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="memId" placeholder="推薦會員" value="${user.memId}">
						</div>
					</div>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">店家名稱</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.name" placeholder="店家名稱">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhone" class="col-sm-2 control-label">店家電話</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputPhone"
								name="bean.phone" placeholder="店家電話">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">店家E-Mail</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputEmail"
								name="bean.email" placeholder="店家Email">
						</div>
					</div>

					<div class="form-group">
						<label for="inputAddr" class="col-sm-2 control-label">店家地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputAddr"
								name="bean.recAddress" placeholder="地址">
						</div>
					</div>

					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">價位</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.price" placeholder="店家價位">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">網站</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.web" placeholder="沒有則填無">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="select1" class="col-sm-2 control-label">餐廳類型</label>
						<div class="col-sm-6">
							<select class="form-control" id="select1" name="shoptypeId">
								<option value="1">素食</option>
								<option value="2">速食店</option>
								<option value="3">比薩</option>
								<option value="4">飯</option>
								<option value="5">麵</option>
								<option value="6">糕點</option>
								<option value="7">咖啡店</option>
								<option value="8">自助餐</option>
								<option value="9">小吃</option>
								<option value="10">火鍋</option>
								<option value="11">快炒</option>
								<option value="12">甜點</option>
							</select>
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">聯絡人</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.contactName" placeholder="選填">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">聯絡人電話</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.contactPhone" placeholder="選填">
						</div>
					</div>

					<div class="form-group">
						<label for="note" class="col-sm-2 control-label">備註</label>
						<div class="col-sm-6">
							<textarea class="form-control" rows="3" id="note"
								name="bean.note" placeholder="備註"></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6 col-md-offset-2">
							<button type="reset" value="Clear" class="btn btn-default">Cancel</button>
							<button type="submit" name="papaAction" value="Insert"
								class="btn btn-primary">確認推薦新增</button>
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