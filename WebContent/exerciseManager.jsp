<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Exercise manager</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<h2>Exercises</h2>
<table border="1">
    <tr>
        <th scope="col">Title</th>
        <th scope="col">Description</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    <c:forEach var="e" items="${exercises}">
        <tr>
            <td>${e.title}</td>
            <td>${e.description}</td>
            <td><a href="/Warsztat_3/exerciseForm.jsp?id=${e.id}">edit</a></td>
            <td><a href="/Warsztat_3/exerciseManager?id=${e.id}">remove</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/Warsztat_3/exerciseForm.jsp?id=0">Add new exercise</a>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>