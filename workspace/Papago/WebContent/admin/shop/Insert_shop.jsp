<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>商家系統</title>
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
				<li><a href="../member/displayallmember.jsp">會員系統</a></li>
				<li class="active"><a href="Insert_shop.jsp">商家系統</a></li>
			</ul>
			</nav>
		</div>
		<!--end of subnavbar -->

		<!-- subbar list 看自己需不需要-->
		<div class="col-sm-3">
			<ul class="nav nav-stacked nav-pills">
				<li class="active text-success"><a href="#" style="text-align:center">商家系統</a></li>
				<li><a href="Insert_shop.jsp">新增店家</a></li>
				<li><a href="RUD_shop.jsp">查詢及刪除修改店家</a></li>
				<li><a href="PriceType.jsp">價位類型表單</a></li>
			</ul>
		</div>
		<!--end of subbar list -->

		<!--其他東西寫在這裡 -->
		<div class="container">
			<div class="container">
				<form class="form-horizontal" role="form"
					enctype="multipart/form-data" method="post"
					action="<c:url value='/admin/shop/rec.action'/>">
					<button type="submit" name="papaAction" value="Select"
						class="btn btn-default">查詢會員推薦店家</button>
				</form>
				<form class="form-horizontal" role="form"
					enctype="multipart/form-data" method="post"
					action="<c:url value='/admin/shop/papashop.action'/>">
					<fieldset>
						<legend>新增店家</legend>
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">店家名稱</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputName"
									name="bean.name" placeholder="請輸入名稱"
									value="${param['bean.name']}">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPhone" class="col-sm-2 control-label">店家電話</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputPhone"
									name="bean.phone" placeholder="請輸入電話"
									value="${param['bean.phone']}">
							</div>
						</div>

						<div class="form-group">
							<label for="inputEmail" class="col-sm-2 control-label">店家E-Mail</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputEmail"
									name="bean.email" placeholder="Email"
									value="${param['bean.email']}">
							</div>
						</div>

						<div class="form-group">
							<label for="inputAddr" class="col-sm-2 control-label">店家地址</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputAddr"
									name="bean.shopAddress" placeholder="請輸入地址"
									value="${param['bean.recAddress']}">
							</div>
						</div>


						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">價位</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputName"
									name="bean.price" placeholder="price"
									value="${param['bean.price']}">
							</div>
						</div>

						<div class="form-group">
							<label for="exampleInputFile" class="col-sm-2 control-label">店家圖片</label>
							<div class="col-sm-6">
								<input type="file" id="exampleInputFile" name="userImage"
									size="40">
								<p class="help-block">不得超過2MB</p>
							</div>
						</div>

						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">聯絡人</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputName"
									name="bean.contactName" placeholder="選填" value="${param['bean.contactName']}">
							</div>
						</div>

						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">聯絡人電話</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputName"
									name="bean.contactPhone" placeholder="選填" value="${param['bean.contactPhone']}">
							</div>
						</div>

						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">網站</label>
							<div class="col-sm-6">
								<input type="text" class="form-control" id="inputName"
									name="bean.web" placeholder="沒有則填無" value="${param['bean.web']}">
							</div>
						</div>

						<div class="form-group">
							<label for="select1" class="col-sm-2 control-label">營業狀態</label>
							<div class="col-sm-6">
								<select class="form-control" id="select1"
									name="sst.shopstatusId">
									<option value="1">營業中</option>
									<option value="2">歇業</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="select1" class="col-sm-2 control-label">餐廳類型</label>
							<div class="col-sm-6">
								<select class="form-control" id="select1" name="st.shoptypeId">
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
							<label for="select1" class="col-sm-2 control-label">價位類型</label>
							<div class="col-sm-6">
								<select class="form-control" id="select1" name="pt.pricetypeId">
									<option value="1">99元以下</option>
									<option value="2">100元~199元</option>
									<option value="3">200元~299元</option>
									<option value="4">300元以上</option>
								</select>
							</div>
						</div>

						<div class="form-group">
							<label for="note" class="col-sm-2 control-label">備註</label>
							<div class="col-sm-6">
								<textarea class="form-control" rows="3" id="note"
									name="bean.note" placeholder="備註">${param['bean.note']}</textarea>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-6 col-md-offset-2">
								<button type="reset" value="Clear" class="btn btn-default">Cancel</button>
								<button type="submit" name="papaAction" value="Insert"
									class="btn btn-primary">確認新增</button>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
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