<%@page import="pl.coderslab.dao.GroupDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>User manager</title>
</head>
<body>
<% request.setAttribute("groups", GroupDao.loadAll()); %>
<%@include file="WEB-INF/fragments/header.jspf"%>
<h2>Users</h2>
<table border="1">
    <tr>
        <th scope="col">Username</th>
        <th scope="col">Email</th>
        <th scope="col">Group</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.username}</td>
            <td>${u.email}</td>
            <td>${u.userGroupId}</td>
            <td><a href="/Warsztat_3/userForm?id=${u.id}">edit</a></td>
            <td><a href="/Warsztat_3/userManager?id=${u.id}">remove</a></td>
        </tr>
    </c:forEach>
</table>
<a href="/Warsztat_3/userForm?id=0">Add new user</a>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>