<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<h2>Welcome ${username}! Your primary role is ${primaryRole}!</h2>
	<c:choose>
		<c:when test="${username=='Invalid password' }">
	${roles}
	</c:when>
		<c:otherwise>
			<h4>Your roles are</h4>
			<c:forEach var="role" items="${roles}">
		${role.userRole}<br>
			</c:forEach>
		</c:otherwise>
	</c:choose>
</body>
</html>
