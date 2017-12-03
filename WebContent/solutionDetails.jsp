<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solution details</title>
</head>
<body>
 <%@include file="WEB-INF/fragments/header.jspf"%>
 <h1>Solution details</h1>
 <h2>Author</h2>
 <%@include file="WEB-INF/fragments/showUsers.jspf"%>
 <h2>Excercise</h2>
 <%@include file="WEB-INF/fragments/showExcercises.jspf"%>
 <%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>