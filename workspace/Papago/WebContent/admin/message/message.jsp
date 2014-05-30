<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript">
var contextPath = "${pageContext.request.contextPath}";
function XXX(){
	
	var shopIds = 9;
	var msgContents = null;
	$.ajax({
		url : contextPath + '/admin/message/message.json',
		type : 'POST',
		dataType : 'JSON',
		data : {
			shopId : shopIds
		},
		success : function(result) {
			msgContents = result.list[0].msgContent;
			alert(msgContents);
		}
	});
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


</head>

<body>
	<button type="submit" name="papaAction" value="Insert"
			class="btn btn-primary" onclick="XXX()">送出</button>
	<form action="<c:url value="/admin/message/papamsg.action" />"
		method="get">

		<div>
			<textarea name="bean.msgContent" rows="2" cols="50"
				class="ugccmt-comments-post-field" style="height: 46px;"
				title="" placeholder=""></textarea>
		</div>
		
	</form>

</body>
</html>