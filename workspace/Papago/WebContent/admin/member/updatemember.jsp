<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>管理員會員更新</title>
<link rel="shortcut icon" href="../../images/papago.ico" type="image/x-icon" />
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
	<!-- set up the modal to start hidden and fade in and out -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						onclick="history.back()">&times;</button>
					<div class="container">
						<form class="form-horizontal" role="form"
							action="<c:url value='/admin/member/resigter.action'/>"
							enctype="multipart/form-data" method="post">
							<fieldset>
								<legend>修改公司會員</legend>
								<div class="form-group">
									<label for="inputAccount" class="col-sm-2 control-label">會員ID</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputAccount"
											name="memid" placeholder="ID"
											value="${select.memId}">
									</div>
								</div>
								<div class="form-group">
									<label for="inputAccount" class="col-sm-2 control-label">會員帳號</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputAccount"
											name="entity.account" placeholder="帳號"
											value="${select.account}">
									</div>
								</div>
								<div class="form-group">
									<label for="inputName" class="col-sm-2 control-label">會員姓名</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputName"
											name="entity.name" placeholder="姓名" value="${select.name}">
									</div>
								</div>

								<div class="form-group">
									<label for="inputPassword" class="col-sm-2 control-label">密碼</label>
									<div class="col-sm-6">
										<input type="password" class="form-control" id="inputPassword"
											name="entity.memPassword" placeholder="Password"
											value="${select.memPassword}">
									</div>
								</div>

								<div class="form-group">
									<label for="inputEmail" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputEmail"
											name="entity.email" placeholder="Email"
											value="${select.email}">
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-2 control-label">性別</label>
									<div class="col-sm-6">
										<div class="radio">
											<label> <input type="radio" name="entity.sex"
												id="optionsRadios1" value="男" checked="">男
											</label>
										</div>
										<div class="radio">
											<label> <input type="radio" name="entity.sex"
												id="optionsRadios2" value="女">女
											</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label for="exampleInputFile" class="col-sm-2 control-label">照片</label>
									<div class="col-sm-6">
										<input type="file" id="exampleInputFile" name="userImage"
											size="40">
										<p class="help-block">不可超過2MB</p>
									</div>
								</div>

								<div class="form-group">
									<label for="inputDate" class="col-sm-2 control-label">生日</label>
									<div class="col-sm-6">
										<div class="input-group date" id="datetimepicker1"
											data-date-format="YYYY-MM-DD">
											<input type="text" class="form-control" name="entity.birth"
												value="${select.birth}" /><span class="input-group-addon"><span
												class="glyphicon glyphicon-time"></span> </span>
										</div>
									</div>
									<script type="text/javascript">
										$(function() {
											$('#datetimepicker1')
													.datetimepicker({
														pickTime : false
													});
										});
									</script>
								</div>

								<div class="form-group">
									<label for="inputPhone" class="col-sm-2 control-label">手機號碼</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputPhone"
											placeholder="Phone" name="entity.phone"
											value="${select.phone}" />
									</div>
								</div>

								<div class="form-group">
									<label for="inputAddr" class="col-sm-2 control-label">地址</label>
									<div class="col-sm-6">
										<input type="text" class="form-control" id="inputAddr"
											placeholder="地址" name="entity.memAddress"
											value="${select.memAddress}" />
									</div>
								</div>

								<div class="form-group">
									<label for="select1" class="col-sm-2 control-label">帳號類別</label>
									<div class="col-sm-6">
										<select class="form-control" id="select1" name="type">
											<option value="1">會員</option>
											<option value="2">管理員</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label for="select2" class="col-sm-2 control-label">帳號狀態</label>
									<div class="col-sm-6">
										<select class="form-control" id="select2" name="status">
											<option value="1">正常</option>
											<option value="2">停用</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<div class="modal-footer">
										<button class="btn btn-default" type="button"  onClick="window.location='displayallmember.jsp'">取消</button>
										<button class="btn btn-danger" type="submit" value="Delete" name="crudAction">刪除</button>
										<button type="submit" class="btn btn-primary"
											name="crudAction" value="Update">修改</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
				<!-- dialog buttons -->

			</div>
		</div>
	</div>

	<!-- sometime later, probably inside your on load event callback -->
	<script>
		$("#myModal").on("show", function() { // wire up the OK button to dismiss the modal when shown
			$("#myModal a.btn").on("click", function(e) {
				console.log("button pressed"); // just as an example...
				$("#myModal").modal('hide'); // dismiss the dialog
			});
		});

		$("#myModal").on("hide", function() { // remove the event listeners when the dialog is dismissed
			$("#myModal a.btn").off("click");
		});

		$("#myModal").on("hidden", function() { // remove the actual elements from the DOM when fully hidden
			$("#myModal").remove();
		});

		$("#myModal").modal({ // wire up the actual modal functionality and show the dialog
			"backdrop" : "static",
			"keyboard" : true,
			"show" : true
		// ensure the modal is shown immediately
		});
	</script>
</body>
</html>