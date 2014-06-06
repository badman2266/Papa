<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
				<li><a href="../shop/search.jsp">店家搜尋</a></li>
				<li><a href="../shop/map.jsp">地圖搜尋</a></li>
<!-- 				<li><a href="#">我的最愛清單</a></li> -->
				<li class="active"><a href="#">店家排行</a></li>
				<li><a href="../recommend/recommend.jsp">店家推薦</a></li>
			</ul>
			</nav>
		</div>

		<!-- subbar list -->
		<div class="col-md-12">
			<ul class="nav nav-pills navbar-default nav-justified nav-stacked">
				<li class="active"><a href="#">周排行 </a></li>
				<li><a href="#">月排行</a></li>
				<li><a href="#">類型排行 </a></li>
			</ul>
		</div>
		<!--end of subbar list -->

		<div class="container col-md-12">
			<table class="table table-striped table-hover ">
				<thead>
					<tr>
						<th>本週</th>
						<th>上週</th>
						<th>店家名稱</th>
						<th>店家評分</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><span class="glyphicon glyphicon-star"></span>1</td>
						<td><a href=""></a></td>
						<td>Column content</td>
						<td>Column content</td>
					</tr>
					<tr>
						<td>2</td>
						<td><a href=""></a></td>
						<td>Column content</td>
						<td>Column content</td>
					</tr>
					<tr>
						<td>3</td>
						<td><a href=""></a></td>
						<td>Column content</td>
						<td>Column content</td>
					</tr>
					<tr>
						<td>4</td>
						<td><a href=""></a></td>
						<td>Column content</td>
						<td>Column content</td>
					</tr>
					<tr>
						<td>5</td>
						<td><a href=""></a></td>
						<td>Column content</td>
						<td>Column content</td>
					</tr>
				</tbody>
			</table>
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