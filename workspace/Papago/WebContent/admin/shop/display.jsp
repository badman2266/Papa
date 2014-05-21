<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="com.cecj03.papago.misc.BoundleMessage_zh_TW" var="message" />
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>價位類型清單</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<link href="../../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<body>
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
				<li><a href="#">地圖搜尋</a></li>
				<li><a href="#">商家排行</a></li>
				<li><a href="#">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		
		
		<div class="col-md-8">
			<h4 class="text-success">查詢 【<fmt:message bundle="${message}" key="priceType"/>】 資訊 : 發現 ${fn:length(select)} 筆資料。</h4>
			<c:if test="${not empty select}">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center"><fmt:message bundle="${message}" key="pricetypeId"/></th>
							<th class="text-center"><fmt:message bundle="${message}" key="priceType"/></th>
						</tr>
					</thead>
					
					<tbody>
						<c:forEach var="bean" items="${select}">
							<c:url var="path" value="/admin/shop/PriceType.jsp">
								<c:param name="pricetypeId" value="${bean.pricetypeId}" />
								<c:param name="priceType" value="${bean.priceType}" />
							</c:url>
							<tr>
								<td class="text-center"><a href="${path}">${bean.pricetypeId}</a></td>
								<td class="text-center">${bean.priceType}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			<h4 class="pull-right"><a href="<c:url value="/admin/shop/PriceType.jsp" />">返回【價位類型表單】</a></h4>
		</div>
	</div>
	<!--end of container-body -->
	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; PaPaGo Team</p>
	</div>
	</footer>
	<!--end of footer -->
</body>
</html>