<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>店家成功!!</title>
<link rel="shortcut icon" href="../../images/papago.ico" type="image/x-icon" />
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
					<button type="button" class="close" data-dismiss="modal" onClick="window.location='displayallmember.jsp'">&times;</button>
					<c:if test="${not empty insert}">
						<h3>新增店家成功!!</h3>
					</c:if>
					<c:if test="${not empty delete}">
						<h3>刪除店家成功!!</h3>
					</c:if>
					<c:if test="${not empty update}">
						<h3>更新店家成功!!</h3>
					</c:if>	
				</div>
				<!-- dialog buttons -->
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" onClick="window.location='Insert_shop.jsp'">OK</button>
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