<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Programming School</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<table border="1" align="center">
 <tr>
  <th scope="row" colspan="6" align="center">Solutions</th>
 </tr>
 <tr>
  <th scope="col">Id</th>
  <th scope="col">Excercise</th>
  <th scope="col">Author</th>
  <th scope="col">Description</th>
  <th scope="col">Created</th>
  <th scope="col">Updated</th>
 </tr>
 <c:forEach var="s" items="${solutions}">
  <tr>
   <td>${s.id}</td>
   <td>${s.excerciseId}</td>
   <td>${s.userId}</td>
   <td>${s.description}</td>
   <td>${s.created}</td>
   <td>${s.updated}</td>
  </tr>
 </c:forEach>
</table>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>