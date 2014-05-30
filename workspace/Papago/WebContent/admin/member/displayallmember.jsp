<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部會員資料</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../../css/bootstrap-datetimepicker.css" rel="stylesheet"
	media="screen">
<link href="../../css/website.css" rel="stylesheet" media="screen">
<link href="//cdn.datatables.net/1.10.0/css/jquery.dataTables.css"
	rel="stylesheet" media="screen">
	
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var table =$('#example').dataTable({
			"ajax" : "<c:url value='/MemberListDisplay.json'/>",
			"columns" : [ {
				"data" : "id"
			}, {
				"data" : "account"
			}, {
				"data" : "name"
			}, {
				"data" : "phone"
			}, {
				"data" : "email"
			}, {
				"data" : "sex"
			}, {
				"data" : "address"
			}, {
				"data" : "birth"
			}, {
				"data" : "type"
			}, {
				"data" : "status"
			} ]
		});
		   $('#example tbody').on( 'click', 'tr', function () {
			   var size = $(this).find("td").length;
			   var srt = "";
			 	for(var i=0;i<size;i++){
			 		srt += $(this).find("td").eq(i).html()+"---";
			 	}
			 	alert(srt);
			 	document.location.href="<c:url value='/admin/member/UpdateMember.controller'/>?srt="+srt;
				//alert($(this).find("td").eq(0).html());
				//document.location.href="http://google.com";
				
		    } );
		
		   $('#TRid>td').each(function(){
			   $(this).text();
		   })
		
		
	});
</script>


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
			<a class="navbar-brand" href="#">美食趴趴Go評價網 管理員系統</a>
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
	<!-- container-body -->
	<div class="container">

		<!-- container-subnavbar -->

		<div class="container">
			<nav class="navbar" role="navigation">
			<ul class="nav nav-tabs nav-justified">
				<!-- <li><a href="#">最新消息</a></li> -->
				<li><a href="#">訊息通知</a></li>
				<li class="active"><a href="#">會員系統</a></li>
				<li><a href="#">商家系統</a></li>
				<li><a href="#">排名系統</a></li>
				<li><a href="#">留言系統</a></li>
			</ul>
			</nav>
		</div>

		<!-- subbar list -->
		<div class="col-sm-3">
			<ul class="nav nav-tabs nav-stacked navbar-default">
				<li><a href="#">新增會員</a></li>
				<li><a href="#">改會員資訊</a></li>
				<li><a href="#">停用會員資訊</a></li>
				<li class="active text-success"><a href="#">查詢會員資訊</a></li>
			</ul>
		</div>
		<!--end of subbar list -->

		<div class="container col-sm-9">
		<legend>查詢會員資訊</legend>
			<table id="example" class="display col-sm-9" cellspacing="0" width="100%">
				<thead>
					<tr>
						<th>會員ID</th>
						<th>帳號</th>
						<th>姓名</th>
						<th>電話</th>
						<th>e-mail</th>
						<th>性別</th>
						<th>地址</th>
						<th>生日</th>
						<th>型態</th>
						<th>狀態</th>
					</tr>
				</thead>

				<tfoot>
					<tr>
						<th>會員ID</th>
						<th>帳號</th>
						<th>姓名</th>
						<th>電話</th>
						<th>e-mail</th>
						<th>性別</th>
						<th>地址</th>
						<th>生日</th>
						<th>型態</th>
						<th>狀態</th>
					</tr>
				</tfoot>
			</table>
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