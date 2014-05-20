<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理員註冊</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../../css/bootstrap-datetimepicker.css" rel="stylesheet"
	media="screen">
<link href="../../css/website.css" rel="stylesheet" media="screen">

<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/moment.min.js"></script>
<script src="../../js/bootstrap-datetimepicker.js"></script>

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
			<a class="navbar-brand" href="#">美食趴趴Go評價網 管理員</a>
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
					<li class="active text-success"><a href="#">新增會員</a></li>
					<li ><a href="#">改會員資訊</a></li>
					<li><a href="#">停用會員資訊</a></li>
					<li><a href="#">查詢會員資訊</a></li>
				</ul>
			</div>
		<!--end of subbar list -->


		<div class="container">
			<form class="form-horizontal" role="form" method="post"
				action="<c:url value='/LoginServlet'/>">
				<fieldset>
					<legend>新增公司會員</legend>
					<div class="form-group">
						<label for="inputAccount" class="col-sm-2 control-label">會員帳號</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputAccount"
								name="account" placeholder="帳號">
						</div>
					</div>
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">會員姓名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="name" placeholder="姓名">
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="col-sm-2 control-label">密碼</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="inputPassword"
								name="password" placeholder="Password">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputEmail"
								name="email" placeholder="Email">
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">性別</label>
						<div class="col-sm-6">
							<div class="radio">
								<label> <input type="radio" name="optionsSex"
									id="optionsRadios1" value="男" checked="">男
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="optionsSex"
									id="optionsRadios2" value="女">女
								</label>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="exampleInputFile" class="col-sm-2 control-label">照片</label>
						<div class="col-sm-6">
							<input type="file" id="exampleInputFile">
							<p class="help-block">有圖有真相</p>
						</div>
					</div>

					<div class="form-group">
						<label for="inputDate" class="col-sm-2 control-label">生日</label>
						<div class="col-sm-6">
							<div class="input-group date" id="datetimepicker1"
								data-date-format="YYYY-MM-DD">
								<input type="text" class="form-control" /><span
									class="input-group-addon"><span
									class="glyphicon glyphicon-time"></span> </span>
							</div>
						</div>
						<script type="text/javascript">
							$(function() {
								$('#datetimepicker1').datetimepicker({
									pickTime : false
								});
							});
						</script>
					</div>

					<div class="form-group">
						<label for="inputPhone" class="col-sm-2 control-label">手機號碼</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputPhone"
								placeholder="Phone">
						</div>
					</div>

					<div class="form-group">
						<label for="inputAddr" class="col-sm-2 control-label">地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputAddr"
								placeholder="地址">
						</div>
					</div>

					<div class="form-group">
						<label for="select1" class="col-sm-2 control-label">帳號類別</label>
						<div class="col-sm-6">
							<select class="form-control" id="select1">
								<option value="會員">會員</option>
								<option value="管理員">管理員</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<label for="select2" class="col-sm-2 control-label">帳號狀態</label>
						<div class="col-sm-6">
							<select class="form-control" id="select2">
								<option value="正常">正常</option>
								<option value="停用">停用</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6 col-md-offset-2">
							<button class="btn btn-default">Cancel</button>
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>
				</fieldset>
			</form>
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