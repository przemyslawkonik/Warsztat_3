<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Solution add</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<h2>Add</h2>
<form action="/Warsztat_3/solutionManager" method="post">
    Description <input type="text" name="description"><br>
    <input type="hidden" name="id" value="${id}">
    Exercise <select name="exercise_id">
    <c:forEach var="e" items="${exercises}">
        <option value="${e.id}">${e.title}</option>
    </c:forEach>
    </select>
    User <select name="user_id">
    <c:forEach var="u" items="${users}">
    <option value="${u.id}">${u.username}</option>
    </c:forEach>
    </select>
    <input type="submit" value="Add solution">
</form>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>