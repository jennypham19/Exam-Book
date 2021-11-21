<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Thêm sách</h1>
	<form action="/book/create" method="post">
		Id:<input type="text" name="id"><br> 
		Name:<input type="text" name="name"><br> 
		Price:<input type="text" name="price"><br>
		<button>Create</button>
		<button>Reset</button>
	</form>

	<c:if test="${not empty mess }">
		<p class="alert alert-success"><%=request.getAttribute("mess")%></p>
	</c:if>

	<c:if test="${not empty error }">
		<p class="alert alert-success"><%=request.getAttribute("error")%></p>
	</c:if>
</body>
</html>