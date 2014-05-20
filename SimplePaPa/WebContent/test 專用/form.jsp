<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value='/form.action'/>" method="get">
<table>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value=""></td>
		<td></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit"></td>
	</tr>
</table>
</form>
</body>
</html>