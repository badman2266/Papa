<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
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
			<a class="navbar-brand" href="#">美食趴趴Go評價網 </a>
		</div>
		
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<!-- 會員 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">會員<b class="caret"></b></a>
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
	<div class="container">
		<div class="page-header">
			<h1>
				美食趴趴Go評價網 <small>歡迎光臨 ${LoginOk.custid}</small>
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
				<li class="active"><a href="#">商家搜尋</a></li>
				<li><a href="../../shop/map.jsp">地圖搜尋</a></li>
				<li><a href="../../rank/rank.jsp">店家排行</a></li>
				<li><a href="../../recommend/recommend.jsp">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		
		
		<div class="col-md-8">
			<h4 class="text-success">價位類型表單</h4>
			<form class="form-inline" action="<c:url value="/admin/shop/pricetype.controller" />" method="GET">
				<div class="form-group">
					<table class="table table-hover">
						<tr>
							<td><label class="control-label">價位類型編號 : </label></td>
							<td><input type="text" name="pricetypeId" value="${param.pricetypeId}" class="form-control"></td>
							<td>${ErrorsMsg.pricetypeId}</td>
						</tr>
						
						<tr>
							<td><label class="control-label">價位類型 : </label></td>
							<td><input type="text" name="priceType" value="${param.priceType}" class="form-control"></td>
							<td>${ErrorsMsg.priceType}</td>
						</tr>
						
						<tr>
							<td colspan="2" class="text-center">
								<button type="submit" class="btn btn-default" name="production" value="Insert">新增</button>
								<button type="submit" class="btn btn-default" name="production" value="Update">修改</button>
								<button type="submit" class="btn btn-default" name="production" value="Delete">刪除</button>
								<button type="submit" class="btn btn-default" name="production" value="Select">查詢</button>
								<button type="button" class="btn btn-default" value="Clear" onclick="clearForm()">清除</button>
							</td>
						</tr>
					</table>
				</div>
			</form>
			
			<h3>${ErrorsMsg.action}</h3>
				<c:if test="${not empty insert}">
					<h3>新增成功！</h3>
					<table class="table table-hover">
						<tr><th>價位類型編號</th><td>${insert.pricetypeId}</td></tr>
						<tr><th>價位類型</th><td>${insert.priceType}</td></tr>
					</table>
				</c:if>
				
				<c:if test="${not empty update}">
					<h3>修改成功！</h3>
					<table class="table table-hover">
						<tr><th>價位類型編號</th><td>${update.pricetypeId}</td></tr>
						<tr><th>價位類型</th><td>${update.priceType}</td></tr>
					</table>
				</c:if>
		</div>
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