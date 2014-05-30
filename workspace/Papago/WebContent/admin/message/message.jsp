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
<li ></li>
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
	
	<!-- begin htmlcommentbox.com -->
 <div id="HCB_comment_box"><a href="http://www.htmlcommentbox.com">Comment Box</a> is loading comments...</div>
 <link rel="stylesheet" type="text/css" href="//www.htmlcommentbox.com/static/skins/bootstrap/twitter-bootstrap.css?v=0" />
 <script type="text/javascript" id="hcb"> /*<!--*/ if(!window.hcb_user){hcb_user={};} (function(){var s=document.createElement("script"), l=(""+window.location).replace(/'/g,"%27") || hcb_user.PAGE, h="//www.htmlcommentbox.com";s.setAttribute("type","text/javascript");s.setAttribute("src", h+"/jread?page="+encodeURIComponent(l).replace("+","%2B")+"&opts=16862&num=10");if (typeof s!="undefined") document.getElementsByTagName("head")[0].appendChild(s);})(); /*-->*/ </script>
<!-- end htmlcommentbox.com -->
	

</body>
</html>