<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of users</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<table border="1" align="center">
 <tr>
  <th scope="row" colspan="3" align="center">List of users</th>
 </tr>
 <tr>
  <th scope="col">Name</th>
  <th scope="col">Email</th>
  <th scope="col">Details</th>
 </tr>
 <c:forEach var="user" items="${users}">
  <tr>
   <td>${user.username}</td>
   <td>${user.email}</td>
   <td><a href="/Warsztat_3/userDetails?id=${user.id}">more</a></td>
  </tr>
 </c:forEach>
</table>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>