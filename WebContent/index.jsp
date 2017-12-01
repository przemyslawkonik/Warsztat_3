<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Programming school</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<table border="1" align="center">
 <tr>
  <th scope="row" colspan="4" align="center">Top ${initParam["number-solutions"]} latest solutions</th>
 </tr>
 <tr>
  <th scope="col">Description</th>
  <th scope="col">Created</th>
  <th scope="col">Updated</th>
  <th scope="col">Details</th>
 </tr>
 <c:forEach var="s" items="${solutions}">
  <tr>
   <td>${s.description}</td>
   <td>${s.created}</td>
   <td>${s.updated}</td>
   <td><a href="/Warsztat_3/solDetails?user_id=${s.userId}&excercise_id=${s.excerciseId}">more</a></td>
  </tr>
 </c:forEach>
</table>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>