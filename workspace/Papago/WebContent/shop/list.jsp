<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="com.cecj03.papago.misc.BoundleMessage_zh_TW" var="message" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" media="screen">
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
				<!-- <li><a href="#">最新消息</a></li> -->
				<li><a href='<c:url value="search.jsp" />'>店家搜尋</a></li>
				<li><a href='<c:url value="map.jsp" />'>地圖搜尋</a></li>
				<!-- <li><a href="../rank/rank.jsp">商家排行</a></li>-->
				<li><a href='<c:url value="../recommend/recommend.jsp" />'>店家推薦</a></li>
			</ul>
			</nav>
		</div>
		
		<div class="container">
			<ul class="breadcrumb" style="margin-bottom: 5px; font-size: 18pX;">
				<li><a href='<c:url value="search.jsp" />'>美食趴趴Go評價網</a></li>
				<li><a href='<c:url value="search.jsp" />'><fmt:message bundle="${message}" key="shoplist"/></a></li>
				<c:if test="${not empty searchtype}">
					<li class="active">${searchtype}</li>
				</c:if>
				
			</ul>
		</div>
		
		<div class="col-md-8">
			<h4 class="text-success">發現 ${fn:length(shoplist)} 筆資料。</h4>
			<c:if test="${not empty shoplist}">
				<table class="table table-hover">
					<c:forEach var="bean" items="${shoplist}" >
						<tr>
							<td bgcolor="#F4F4F4">
								<strong><a href='<c:url value="papashop.controller?production=Select&shopId=${bean.shopId}" />'><font size="4">${bean.name}</font></a></strong><br>
								類型：${bean.shopType.shopType}　價格：${bean.price}<br>
								<span class="text-right"><a href='<c:url value="papashop.controller?production=Select&shopId=${bean.shopId}" />'><font color="#0000FF">更多【${bean.name}】的資料</font></a></span><br>
<!-- 								<blockquote>最新食記<br> -->
<!-- 									巧克力以及原味泡芙差別只在外酥皮的口味　內餡都是一樣的,基本上酥皮是吃不太出來有巧克力的味道　味覺很敏捷的人就另當別論了！！一盒總共有２０顆小泡芙　　大小與豆酥朋差不多<br> -->
<!-- 								</blockquote> -->
<%-- 								${bean.phone} --%>
<%-- 								${bean.email} --%>
<%-- 								${bean.shopPic} --%>
<%-- 								${bean.shopAddress} --%>
<%-- 								${bean.shopType.shopType} --%>
<%-- 								${bean.shopStatusType.shopStatus} --%>
<%-- 								${bean.shopDate} --%>
<%-- 								${bean.contactName} --%>
<%-- 								${bean.contactPhone} --%>
<%-- 								${bean.price} --%>
<%-- 								${bean.web} --%>
<%-- 								${bean.note} --%>
<%-- 								${bean.priceType.priceType} --%>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
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