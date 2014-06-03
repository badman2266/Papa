<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>變更密碼</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
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
					data-toggle="dropdown">${user.account}會員<b class="caret"></b></a>
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
				<li><a href="#">商家搜尋</a></li>
				<li class="active"><a href="#">地圖搜尋</a></li>
				<li><a href="#">商家排行</a></li>
				<li><a href="#">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		

	</div>
	<!-- / body container -->
	<div class="container">
		<form class="form-horizontal" role="form"
			action="<c:url value='/account/changpwd.action'/>"
			 method="post">
			<fieldset>
				<legend>更改密碼</legend>
					<input type="hidden" id="disabledTextInput" class="form-control" placeholder="${user.account}" name="account" value="${user.account}" >
				<div class="form-group">
					<label for="inputAddr" class="col-sm-2 control-label">舊密碼</label>
					<div class="col-sm-6">
						<p class="form-control-static">
							<input type="password" class="form-control" id="inputPassword"
								name="oldPassword" placeholder="Password">
						</p>
					</div>
				</div>
				<div class="form-group">
					<label for="inputAddr" class="col-sm-2 control-label">新密碼</label>
					<div class="col-sm-6">
						<input type="password" class="form-control" id="inputPassword"
							name="newPassword" placeholder="Password">
					</div>
				</div>
				<div class="form-group">
					<div class="col-md-6 col-md-offset-2">
						<button class="btn btn-default">Cancel</button>
						<button type="submit" class="btn btn-primary" name="crudAction"
							value="Change">Submit</button>
					</div>
					<div class="text-center alert"><p style="color:red">${errors.changepwd[0]}</p></div>
				</div>
			</fieldset>
		</form>


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