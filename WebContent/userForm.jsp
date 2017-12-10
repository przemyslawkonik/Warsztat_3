<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User form</title>
</head>
<body>
<form action="/Warsztat_3/userManager" method="post">
    Username <input type="text" name="username"><br>
    Email <input type="text" name="email"><br>
    Password <input type="text" name="password"><br>
    Group <select name="group_id">
        <c:forEach var="g" items="${groups}">
        <option value=${g.id}>${g.name}</option>
        </c:forEach>
    <input type="hidden" name="id" value="${param.id}">
    <c:if test="${param.id == 0}">
        <input type="submit" value="Add user">
    </c:if>
    <c:if test="${param.id > 0}">
        <input type="submit" value="Edit user">
    </c:if>
</form>
</body>
</html>
