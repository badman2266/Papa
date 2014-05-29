<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="/admin/message/papamsg.action" />" method="get">
<c:if test="${not empty select}">
<c:forEach var="bean" items="${select}">
<li>${bean.msgcontent}</li>
</c:forEach>
</c:if>
<div>
<textarea name="bean.msgContent"  rows="2" cols="50"  class="ugccmt-comments-post-field" style="height: 46px;" title="留言⋯⋯" placeholder="留言⋯⋯"></textarea>
</div>
<button type="submit" name="papaAction" value="Insert" class="btn btn-primary">送出</button>
</form>

</body>
</html>