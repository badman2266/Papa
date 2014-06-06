<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="../../css/bootstrap.min.css" rel="stylesheet" media="screen">
</head>
<link href="../../css/bootstrap-theme.min.css" rel="stylesheet"
	media="screen">
<link href="../../css/website.css" rel="stylesheet" media="screen">
<script src="http://code.jquery.com/jquery.js"></script>
<script src="../../js/bootstrap.min.js"></script>
</head>
<body>
	<!-- set up the modal to start hidden and fade in and out -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<legend>確定要刪除會員推薦嗎?</legend>
					<form action="<c:url value='/admin/shop/rec.action'/>" class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputName" class="col-sm-2 control-label">會員店家ID</label>
							<div class="col-sm-6">
								<input type="text" value="${param['bean.recId']}"
									name="bean.recId" class="form-control">
							</div>
						</div>
						<!-- dialog buttons -->
						<div class="modal-footer">
							<button type="submit" name="papaAction" value="Delete"
								class="btn btn-primary btn-danger">刪除</button>
						</div>
					</form>
				</div>

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