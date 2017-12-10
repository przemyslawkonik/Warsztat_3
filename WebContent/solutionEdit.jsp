<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Solution edit</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<h2>Edit</h2>
<form action="/Warsztat_3/solutionManager" method="post">
    Description <input type="text" name="description">
    <input type="hidden" name="id" value="${param.id}">
    <input type="submit" value="Edit solution">
</form>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>