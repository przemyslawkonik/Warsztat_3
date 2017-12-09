<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Group manager</title>
</head>
<body>
 <%@include file="WEB-INF/fragments/header.jspf"%>
 <h2>Groups</h2>
 <table border="1">
  <tr>
   <th scope="col">Name</th>
   <th scope="col"></th>
   <th scope="col"></th>
  </tr>
  <c:forEach var="g" items="${groups}">
   <tr>
    <td>${g.name}</td>
    <td><a href="/Warsztat_3/editGroup.jsp?id=${g.id}">edit</a></td>
    <td><a href="/Warsztat_3/groupManager?remove_id=${g.id}">remove</a></td>
   </tr>
  </c:forEach>
 </table>
 <%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>