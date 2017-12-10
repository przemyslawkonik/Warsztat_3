<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Solution manager</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<h2>Solutions</h2>
<table border="1">
    <tr>
        <th scope="col">Created</th>
        <th scope="col">Updated</th>
        <th scope="col">Description</th>
        <th scope="col">User</th>
        <th scope="col">Exercise</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    <c:forEach var="s" items="${solutions}">
        <tr>
            <td>${s.created}</td>
            <td>${s.updated}</td>
            <td>${s.description}</td>
            <td>${s.userId}</td>
            <td>${s.exerciseId}</td>
            <td><a href="/Warsztat_3/solutionEdit.jsp?id=${s.id}">edit</a></td>
            <td><a href="/Warsztat_3/solutionManager?id=${s.id}">remove</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/Warsztat_3/solutionAdd?id=0">Add new solution</a>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>