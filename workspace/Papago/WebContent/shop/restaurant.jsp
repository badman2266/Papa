<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="com.cecj03.papago.misc.BoundleMessage_zh_TW"
	var="message" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>【美食趴趴Go評價網】今天想吃什麼？</title>
<style type="text/css">
.map {
	width: 100%;
	height: 300px
}

/*th {
	color: #7D6041;
	font-size: 14pt;
}*/
</style>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<!-- Include Google Maps API (Google Maps API v3 已不需使用 API Key) -->
<script
	src="http://maps.google.com/maps/api/js?sensor=false&amp;language=zh-TW"></script>
<!-- Require jQuery v1.7.0 or newer -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../js/jquery.tinyMap.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		var addr = $('span#address').html();
		$('.map').tinyMap({
			center : addr,
			zoom : 15,
			marker : [ {
				addr : addr,
				text : addr,
			} ]
		});
	});
</script>
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
					data-toggle="dropdown">${user.account}${user.memType.memType}<b
						class="caret"></b></a>
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
				<li class="active"><a href='<c:url value="search.jsp" />'>店家搜尋</a></li>
				<li><a href='<c:url value="map.jsp" />'>地圖搜尋</a></li>
				<!-- <li><a href="../rank/rank.jsp">商家排行</a></li>-->
				<li><a href='<c:url value="../recommend/recommend.jsp" />'>店家推薦</a></li>
			</ul>
			</nav>
		</div>

		<div class="container">
			<ul class="breadcrumb" style="margin-bottom: 5px; font-size: 18pX;">
				<li><a href='<c:url value="search.jsp" />'>美食趴趴Go評價網</a></li>
				<c:if test="${not empty select}">
					<c:forEach var="bean" items="${select}">
						<li><a
							href='<c:url value="papashop.controller?production=SelectType&shoptypeId=${bean.shopType.shoptypeId}" />'>${bean.shopType.shopType}</a></li>
						<li class="active">${bean.name}</li>
					</c:forEach>
				</c:if>
			</ul>

			<div class="col-md-4 col-sm-6">
				<div class="map" id="m1"></div>
			</div>
			<c:if test="${not empty select}">
				<div class="col-md-8 col-sm-6">
					<table class="table">
						<c:forEach var="bean" items="${select}">
							<tr>
								<td>
									<table class="table">
										<tr>
											<td colspan="4"><h3>${bean.name}</h3></td>
										</tr>
										<tr>
											<th>類型:</th>
											<td>${bean.shopType.shopType}</td>
											<th>店家狀態：</th>
											<td>${bean.shopStatusType.shopStatus}</td>
										</tr>
										<tr>
											<th>電子信箱：</th>
											<td>${bean.email}</td>
											<th>電話：</th>
											<td>${bean.phone}</td>
										</tr>
										<tr>
											<th>地址：</th>
											<td><span id="address">${bean.shopAddress}</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
											<c:if test="${not empty bean.web}">
												<th>官方網站：</th>
												<td><a href="${bean.web}" target="_blank">有</a></td>
											</c:if>
										</tr>
										<tr>
											<th>價格：</th>
											<td>${bean.price}</td>
											<th>價位區間：</th>
											<td>${bean.priceType.priceType}</td>
										</tr>
										<c:if test="${not empty bean.contactName}">
											<tr>
												<th>聯絡人：</th>
												<td>${bean.contactName}</td>
												<th>聯絡人電話：</th>
												<td>${bean.contactPhone}</td>
											</tr>
										</c:if>
										<c:if test="${not empty bean.note}">
											<tr>
												<th>店家備註</th>
												<td colspan="4">${bean.note}</td>
											</tr>
										</c:if>
									</table>
								</td>
								<!--  
							<c:if test="${not empty bean.shopPic}">
								<td><img src="${bean.shopPic}" width="100" border="0"></td>
							</c:if>
							-->
							</tr>
							<tr>
								<td>
									<!-- Button trigger modal 頁面按鈕-->
									<div align="right">
										 最後更新日期：${bean.shopDate}<br><br>
										<button class="btn btn-info" data-toggle="modal"
											data-target="#myModal">店家資訊回報</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>

			<!-- 這裡以下是顯示留言區 -->
			<%-- 			<c:if test="${not empty select}"> --%>
			<!-- 				<div class="container"> -->
			<!-- 				<table class="table table-hover"> -->
			<%-- 					<c:forEach var="bean" items="${select}" > --%>
			<!-- 						<tr> -->
			<!-- 							<td> -->
			<%-- 								<strong><font size="4">${bean.name}</font></strong> --%>
			<!-- 									<figure style="float: right;"> -->
			<%-- 										<c:if test="${not empty bean.shopPic}"> --%>
			<%-- 											<img src="${bean.shopPic}" width="100" border="0"> --%>
			<%-- 										</c:if> --%>
			<!-- 									</figure><br> -->
			<%-- 								類型：${bean.shopType.shopType}　店家狀態：${bean.shopStatusType.shopStatus}<br> --%>
			<%-- 								地址：<span id="address">${bean.shopAddress}</span><br> --%>
			<%-- 								電子信箱：${bean.email}<br> --%>
			<%--  								<c:if test="${not empty bean.web}"> --%>
			<%--  									官方網站：<a href="${bean.web}" target="_blank">有</a><br> --%>
			<%--  								</c:if> --%>
			<%--  								電話：${bean.phone}<br> --%>
			<%-- 								價格：${bean.price}　價位區間：${bean.priceType.priceType}<br> --%>
			<%-- 								<c:if test="${not empty bean.note}"> --%>
			<!-- 									<blockquote>店家備註<br> -->
			<%-- 										${bean.note}<br> --%>
			<!-- 									</blockquote> -->
			<%-- 								</c:if> --%>
			<!-- 							</td> -->
			<!-- 						</tr> -->

			<!-- 						<tr> -->
			<!-- 							<td> -->
			<%-- 								<c:if test="${not empty bean.contactName}">聯絡人：${bean.contactName}　聯絡人電話：${bean.contactPhone}<br></c:if> --%>
			<!-- 								<div align="right"> -->
			<%-- 									最後更新日期：${bean.shopDate}<br> --%>
			<!-- 									<a href="guest.php?do=report&amp;rsn=269" target="_blank" class="smalla">店家資料錯誤回報</a> -->
			<!-- 								</div> -->
			<!-- 							</td> -->
			<!-- 						</tr> -->
			<%-- 					</c:forEach> --%>
			<!-- 				</table> -->
			<!-- 				</div> -->

			<!-- 				<ul class="pagination"> -->

			<%-- 				<c:if test="${pageNo > 1}"> --%>
			<%-- 					<li><a href="list.do?pageNo=${pageNo-1}">«</a></li> --%>
			<%-- 				</c:if> --%>
			<%-- 				<c:if test="${pageNo <= 1}"> --%>
			<!-- 					<li class="disabled">«</li> -->
			<%-- 				</c:if> --%>

			<%-- 				<c:forEach items="${pages}" var="page"> --%>
			<%-- 					<c:choose> --%>
			<%-- 						<c:when test="${page == pageNo}"> --%>
			<%-- 							<li class="active"><a href="list.do?pageNo=${page}">${page}</a></li> --%>
			<%-- 						</c:when> --%>

			<%-- 						<c:otherwise> --%>
			<%-- 							<li><a href="list.do?pageNo=${page}">${page}</a></li> --%>
			<%-- 						</c:otherwise> --%>
			<%-- 					</c:choose> --%>
			<%-- 				</c:forEach> --%>

			<%-- 				<c:if test="${pageNo < totalPages}"> --%>
			<%-- 					<a href="list.do?pageNo=${pageNo+1}">»</a> --%>
			<%-- 				</c:if> --%>

			<%-- 				<c:if test="${pageNo < totalPages}"> --%>
			<%-- 					<li><a href="list.do?pageNo=${pageNo+1}">»</a></li> --%>
			<%-- 				</c:if> --%>
			<%-- 				<c:if test="${pageNo >= totalPages}"> --%>
			<!-- 					<li class="disabled">»</li> -->
			<%-- 				</c:if> --%>
			<!-- 			</ul> -->

			<%-- 			</c:if> --%>


			<div class="container">
				<!-- 留言部分 -->
				<c:set value="${user.memType.memtypeId}" var="prior"></c:set>
				<h4>對這個店家留個言吧，目前尚有 ${fn:length(msg)} 篇留言。</h4>
				<c:if test="${not empty msg}">
					<ul class="list-group">
						<c:forEach var="bean" items="${msg}">
							<li class="list-group-item"><a href='<c:url value="#" />'><img
									src='<c:url value="../images/icon_avatar.jpg" />'
									class="avatar" width="50"></a>
								<p class="name">
									<a href='<c:url value="#" />'>${bean.papaMem.name}</a> <span
										class="date"><fmt:formatDate value="${bean.msgDate}"
											pattern="yyyy/MM/dd EEEE" /></span>
								</p>
								<div class="content">${bean.msgContent}</div> <!-- 刪除留言 --> <c:if
									test="${prior==2}">
									<form action='<c:url value="/shop/deletemessage.controller" />'
										method="post">
										<input type="hidden" name="msgId" value="${bean.msgId}">
										<c:if test="${not empty select}">
											<c:forEach var="bean" items="${select}">
												<input type="hidden" name="shopId" value="${bean.shopId}">
											</c:forEach>
										</c:if>
										<button type="submit" name="production" value="deletemessage"
											class="btn btn-danger">刪除</button>
									</form>
								</c:if> <!-- / 刪除留言 --></li>
						</c:forEach>
					</ul>
				</c:if>
				<!-- insert留言 -->
				<form action='<c:url value="/shop/papashop.controller" />'
					method="post">
					<c:if test="${not empty select}">
						<c:forEach var="bean" items="${select}">
							<input type="hidden" name="shopId" value="${bean.shopId}">
						</c:forEach>
					</c:if>
					<input type="hidden" name="memId" value="${user.memId}">
					<textarea name="msgContent" class="form-control" rows="3"
						title="留言" placeholder="留言..."></textarea>
					<br>
					<button type="submit" name="production" value="writemessage"
						class="btn btn-primary">送出</button>
				</form>
				<!-- / insert留言 -->
				<!-- / 留言部份 -->
			</div>
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

	<!-- Modal 按下去才會顯示的內容-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">回報店家資訊內容</h4>
				</div>
				<div class="modal-body">
					<form action="<c:url value='/admin/shop/updateshop.controller'/>"
						class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">店家ID</label>
							<div class="col-sm-10">
								<c:forEach var="bean" items="${select}">
									<input type="text" value="${bean.shopId}" name="shopId"
										class="form-control">
								</c:forEach>
							</div>
						</div>
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">會員ID</label>
							<div class="col-sm-10">
								<input type="text" value="${user.memId}" name="memId"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">店家更新回報內容</label>
							<div class="col-sm-10">
								<textarea class="form-control" rows="5" name="updateContent"></textarea>
							</div>
						</div>
						<!-- dialog buttons -->
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">關閉</button>
							<button type="submit" name="production" value="Insert"
								class="btn btn-primary btn-success">確認回報</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal 按下去才會顯示的內容-->
</body>
</html>