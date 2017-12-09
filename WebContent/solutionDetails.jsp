<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Solution details</title>
</head>
<body>
 <%@include file="WEB-INF/fragments/header.jspf"%>
 <h2>Exercise description</h2>
 <p>${exercise.description}</p>
 <h2>Solution</h2>
 <p>${solution.description}</p>
 <%@include file="WEB-INF/fragments/footer.jspf"%>
</body>
</html>