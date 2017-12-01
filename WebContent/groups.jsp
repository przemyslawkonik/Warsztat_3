<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List of groups</title>
</head>
<body>
<%@include file="WEB-INF/fragments/header.jspf"%>
<table border="1" align="center">
 <tr>
  <th scope="row" colspan="2" align="center">Groups</th>
 </tr>
 <tr>
  <th scope="col">Name</th>
  <th scope="col">Details</th>
 </tr>
 <c:forEach var="group" items="${groups}">
  <tr>
   <td>${group.name}</td>
   <td><a href="/Warsztat_3/groupDetails?id=${group.id}">more</a></td>
  </tr>
 </c:forEach>
</table>
<%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>