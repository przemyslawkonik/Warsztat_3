<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Group form</title>
</head>
<body>
<form action="/Warsztat_3/groupManager" method="post">
    <input type="text" name="name">
    <input type="hidden" name="id" value="${id}">
    <c:if test="${id == 0}">
        <input type="submit" value="Add group">
    </c:if>
    <c:if test="${id > 0}">
        <input type="submit" value="Edit group">
    </c:if>
</form>
</body>
</html>
