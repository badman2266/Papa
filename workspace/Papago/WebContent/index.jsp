<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
	<form action='<c:url  value="/xxx/gogo.action"/>' method="post" enctype="multipart/form-data">
	<input type="file" name="fieldName"/>
	<input type="submit" value="up" />  
	 </form>
</body>