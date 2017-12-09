<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Exercise details</title>
</head>
<body>
 <%@include file="WEB-INF/fragments/header.jspf"%>
 <h2>Exercise description</h2>
 <p>${exercise.description}</p>
 <h2>All known Solutions</h2>
 <%@include file="WEB-INF/fragments/showSolutions.jspf"%>
 <%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>