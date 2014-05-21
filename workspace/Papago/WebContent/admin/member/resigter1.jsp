<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form class="form-horizontal" role="form"
		action="<c:url value='/member/resigter.action'/>">
		<fieldset>
			<legend>新增公司會員</legend>
			<div class="form-group">
				<label for="inputAccount" class="col-sm-2 control-label">會員帳號</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputAccount"
						name="bean.account" placeholder="帳號">
				</div>
			</div>
			<div class="form-group">
				<label for="inputName" class="col-sm-2 control-label">會員姓名</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputName"
						name="bean.name" placeholder="姓名">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">密碼</label>
				<div class="col-sm-6">
					<input type="password" class="form-control" id="inputPassword"
						name="bean.password" placeholder="Password">
				</div>
			</div>

			<div class="form-group">
				<label for="inputEmail" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputEmail"
						name="bean.email" placeholder="Email">
				</div>
			</div>

			<div class="form-group">
				<label class="col-sm-2 control-label">性別</label>
				<div class="col-sm-6">
					<div class="radio">
						<label> <input type="radio" name="bean.sex"
							id="optionsRadios1" value="男" checked="">男
						</label>
					</div>
					<div class="radio">
						<label> <input type="radio" name="bean.sex"
							id="optionsRadios2" value="女">女
						</label>
					</div>
				</div>
			</div>

			<!--  					<div class="form-group">
						<label for="exampleInputFile" class="col-sm-2 control-label">照片</label>
						<div class="col-sm-6">
							<input type="file" id="exampleInputFile">
							<p class="help-block">有圖有真相</p>
						</div>
					</div>-->

			<div class="form-group">
				<label for="inputDate" class="col-sm-2 control-label">生日</label>
				<div class="col-sm-6">
					<div class="input-group date" id="datetimepicker1"
						data-date-format="YYYY-MM-DD">
						<input type="text" class="form-control" name="bean.birth" /><span
							class="input-group-addon"><span
							class="glyphicon glyphicon-time"></span> </span>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPhone" class="col-sm-2 control-label">手機號碼</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputPhone"
						placeholder="Phone" name="bean.phone">
				</div>
			</div>

			<div class="form-group">
				<label for="inputAddr" class="col-sm-2 control-label">地址</label>
				<div class="col-sm-6">
					<input type="text" class="form-control" id="inputAddr"
						placeholder="地址" name="bean.maddress">
				</div>
			</div>

			<div class="form-group">
				<label for="select1" class="col-sm-2 control-label">帳號類別</label>
				<div class="col-sm-6">
					<select class="form-control" id="select1" name="bean.mtypeid">
						<option value="1">會員</option>
						<option value="2">管理員</option>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="select2" class="col-sm-2 control-label">帳號狀態</label>
				<div class="col-sm-6">
					<select class="form-control" id="select2" name="bean.mstatusid">
						<option value="1">正常</option>
						<option value="2">停用</option>
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
	<form class="form-horizontal" role="form"
		action="<c:url value='/userimage/image.action'/>" enctype="multipart/form-data" method="post">
		<fieldset>
			<div class="form-group">
				<label for="exampleInputFile" class="col-sm-2 control-label">照片</label>
				<div class="col-sm-6">
					<input type="file" id="exampleInputFile" name="userImage" size="40">
					<p class="help-block">有圖有真相</p>
				</div>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</fieldset>
	</form>


</body>
</html>