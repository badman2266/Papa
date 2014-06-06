<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/website.css" rel="stylesheet" media="screen">
<link href="../css/page-style.css" rel="stylesheet">

<script src="http://code.jquery.com/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
</head>
<body>
	<!-- body container -->
	<nav class="navbar navbar-inverse navbar-static-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="../index.jsp">美食趴趴Go評價網 </a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<!-- 會員 -->
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
	<div class="container">
		<div class="page-header">
			<h1>
				美食趴趴Go評價網 <small>今天想吃什麼？</small>
			</h1>
		</div>
	</div>
	<!-- container-body -->
	<div class="container">
		<!-- container-subnavbar -->
		<div class="container">
			<nav class="navbar" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<!-- <li><a href="#">最新消息</a></li> -->
				<li class="active"><a href='<c:url value="#" />'>店家搜尋</a></li>
				<li><a href='<c:url value="map.jsp" />'>地圖搜尋</a></li>
				<!-- <li><a href="../rank/rank.jsp">商家排行</a></li>-->
				<li><a href='<c:url value="../recommend/recommend.jsp" />'>店家推薦</a></li>
			</ul>
			</nav>
		</div>


		<!-- chance to select the product -->
		<div class="col-md-8">
            
            <div id="menuBox-1" class="menuBox-bg-color-1">
            
            <h4 class="text-success"><span class="glyphicon glyphicon-thumbs-up"></span>&nbsp
			不知道今天要吃什麼嗎？</h4>
			<form class="form-inline" action='<c:url value="papashop.controller" />' method="POST">
				<div class="form-group">
					<label class="control-label">種類 ： </label>
					<select	class="form-control" name="choosetype">
						<option selected="selected" value="200">不限</option>
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
				&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="form-group">
					<label class="control-label">價位 ： </label>
					<select	class="form-control" name="optprice">
						<option selected="selected" value="200">不限</option>
						<option value="1">99元以下</option>
						<option value="2">100元~199元</option>
						<option value="3">200元~299元</option>
						<option value="4">300元以上</option>
					</select>
				</div>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="checkbox">
					<label>
						<input type="checkbox" name="randshop" value="rndd">&nbsp;隨機推薦給我&nbsp;&nbsp;
					</label>
				</div>
				<button type="submit" class="btn btn-default" name="production" value="RecMe" 
					onclick="if(this.form.choosetype.value == '200' && this.form.optprice.value == '200' && !this.form.randshop.checked){alert('請選擇店家類型或價位類型');return false;}">送出</button>
			</form>
            
            </div>
            
			<!--</div> -->
			<!-- end of chance to select the product -->

			<!-- select the product in keyword-->
			<!-- <div class="col-md-8">-->
            
            <div id="menuBox-1" class="menuBox-bg-color-2">
            
			<h4 class="text-success"><span class="glyphicon glyphicon-search"></span>&nbsp關鍵字店家搜尋</h4>
			<form class="form-inline" role="search" action='<c:url value="papashop.controller" />' method="POST">
				<div class="form-group">
					<label class="control-label">店家:</label>
					<input type="text" name="name" class="form-control" placeholder="搜尋店家名稱" maxlength="10" onfocus="this.value=''">
					<button type="submit" class="btn btn-default" name="production" value="CharSelect" onclick="if(this.form.name.value == '搜尋店家名稱' || this.form.name.value == ''){alert('請輸入要搜尋的店家名稱');return false;}">搜尋</button>
				</div>
			</form>
            
            </div>
            
			<!-- </div> -->
			<!-- end of select the product in keyword -->

			<!-- select from price -->
			<!-- <div class="col-md-8">-->
            
            <div id="menuBox-1" class="menuBox-bg-color-3">
            
			<h4 class="text-success"><span class="glyphicon glyphicon-usd"></span>&nbsp價位搜尋</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th colspan="3" class="text-center">價位</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td rowspan="2" class="text-center">價位</td>
						<td><a href='<c:url value="papashop.controller?production=SelectPrice&pricetypeId=1" />'>99元以下</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectPrice&pricetypeId=2" />'>100元~199元</a></td>
					</tr>
					<tr>

						<td><a href='<c:url value="papashop.controller?production=SelectPrice&pricetypeId=3" />'>200元~299元</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectPrice&pricetypeId=4" />'>300元以上</a></td>
					</tr>
				</tbody>
			</table>
                        
            </div>
            
			<!-- </div> -->
			<!-- end of select from price -->

			<!-- select from type -->
			<!-- <div class="col-md-8"> -->
            
            <div id="menuBox-1" class="menuBox-bg-color-3">
            
			<h4 class="text-success"><span class="glyphicon glyphicon-cutlery"></span>&nbsp類型搜尋</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th colspan="4" class="text-center">類型</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td rowspan="4" class="text-center">類型</td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=1" />'>素食</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=2" />'>速食店</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=3" />'>比薩</a></td>
					</tr>
					<tr>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=4" />'>飯</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=5" />'>麵</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=6" />'>糕點</a></td>
					</tr>
					<tr>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=7" />'>咖啡店</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=8" />'>自助餐</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=9" />'>小吃</a></td>
					</tr>
					<tr>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=10" />'>火鍋</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=11" />'>快炒</a></td>
						<td><a href='<c:url value="papashop.controller?production=SelectType&shoptypeId=12" />'>甜點</a></td>
					</tr>
				</tbody>
			</table>
            
            </div>
            
		</div>
		<!-- end of select from type -->

		
	</div>
	<!--end of container-body -->
	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; Copyright 2013-2014 PaPaGo 美食團隊</p>
	</div>
	</footer>
	<!--end of footer -->

</body>

</html>