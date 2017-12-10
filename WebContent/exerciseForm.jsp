<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise form</title>
</head>
<body>
<form action="/Warsztat_3/exerciseManager" method="post">
    Title <input type="text" name="title">
    Description <input type="text" name="description">
    <input type="hidden" name="id" value="${param.id}">
    <c:if test="${param.id == 0}">
        <input type="submit" value="Add exercise">
    </c:if>
    <c:if test="${param.id > 0}">
        <input type="submit" value="Edit exercise">
    </c:if>
</form>
</body>
</html>
