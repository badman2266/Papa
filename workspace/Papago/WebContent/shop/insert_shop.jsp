<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>店家推薦</title>
<link href="../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<link href="../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	var options = document.getElementsByTagName("option");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
	for(var i=0; i<options.length; i++)
}
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
				<li><a href="#">商家搜尋</a></li>
				<li><a href="#">地圖搜尋</a></li>
				<li><a href="#">商家排行</a></li>
				<li class="active"><a href="#">店家推薦</a></li>
			</ul>
			</nav>
		</div>
		<h4 class="text-success">店家資訊頁面</h4>


		<h4 class="text-success">留言</h4>


	</div>
	<!-- / body container -->
	<div class="container">
			<form class="form-horizontal" role="form" method="get"
				action="<c:url value="/shop/papashop.action" />">
				<fieldset>
					<legend>新增店家</legend>
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">店家名稱</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName"
								name="bean.name" placeholder="請輸入名稱" value="${param['bean.name']}">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPhone" class="col-sm-2 control-label">店家電話</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputPhone"
								name="bean.phone" placeholder="請輸入電話" value="${param['bean.phone']}">
						</div>
					</div>

					<div class="form-group">
						<label for="inputEmail" class="col-sm-2 control-label">店家E-Mail</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputEmail"
								name="bean.email" placeholder="Email" value="${param['bean.email']}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputAddr" class="col-sm-2 control-label">店家地址</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputAddr" name="bean.shopAddress"
								placeholder="請輸入地址" value="${param['bean.shopAddress']}">
						</div>
					</div>

				
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">價位</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="inputName" name="bean.price"
								placeholder="price" value="${param['bean.price']}">
						</div>
					</div>			
									
				
<!-- 				<div class="form-group">
						<label for="exampleInputFile" class="col-sm-2 control-label">店家圖片</label>
						<div class="col-sm-6">
							<input type="file" id="exampleInputFile">
							<p class="help-block">有圖有真相</p>
						</div>
					</div> -->
<%-- 					<div class="form-group">
						<label  class="col-sm-2 control-label">營業時間</label>
						<div class="col-sm-6">
							<input type="text" id="shopDate" name="bean.shopDate" value="${param['bean.shopDate']}" data-date-format="YYYY-MM-DD">
						</div>
					</div> --%>
					<div class="form-group">
						<label for="select1" class="col-sm-2 control-label">營業狀態</label>
						<div class="col-sm-6">
							<select class="form-control" id="select1" name="sst.shopstatusId">
								<option  value="1">營業中</option>
								<option	 value="2">歇業</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="select1" class="col-sm-2 control-label">餐廳類型</label>
						<div class="col-sm-6">
							<select class="form-control" id="select1" name="st.shoptypeId">
								<option  value="1">素食</option>
								<option	 value="2">速食店</option>
								<option	 value="3">比薩</option>
								<option	 value="4">飯</option>
								<option	 value="5">麵</option>
								<option	 value="6">糕點</option>
								<option	 value="7">咖啡店</option>
								<option	 value="8">自助餐</option>
								<option	 value="9">小吃</option>
								<option	 value="10">火鍋</option>
								<option	 value="11">快炒</option>
								<option	 value="12">甜點</option>
								
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="select1" class="col-sm-2 control-label">價位類型</label>
						<div class="col-sm-6">
							<select class="form-control" id="select1" name="pt.pricetypeId">
								<option  value="1">99元以下</option>
								<option	 value="2">100元~199元</option>
								<option	 value="3">200元~299元</option>
								<option	 value="4">300元以上</option>
							</select>
						</div>
					</div>

					

					<div class="form-group">
						<div class="col-md-6 col-md-offset-2">
							<button type="reset" value="Clear" class="btn btn-default">Cancel</button>
							<button type="submit" name="papaAction" value="Insert" class="btn btn-primary">確認新增 </button>
						</div>
					</div>
				</fieldset>
			</form>
		</div>
		<h3>${errors.action}</h3>
<c:if test="${not empty insert}">
	<h3>Insert success</h3>
<table>
		<tr><td>shopId</td><td>${insert.shopId}</td></tr>
		<tr><td>Name</td><td>${insert.name}</td></tr>
		<tr><td>Phone</td><td>${insert.phone}</td></tr>
		<tr><td>shopAddress</td><td>${insert.shopAddress}</td></tr>
		
	</table>
</c:if>
	<!-- footer -->
	<footer>
	<div class="container">
		<p class="pull-right">&copy; PaPaGo Team</p>
	</div>
	</footer>
	<!--end of footer -->

</body>
</html>