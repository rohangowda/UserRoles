<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta charset="utf-8">
<title>Welcome</title>
</head>
<body>
	<form method='post' action='authentication'>
		UserName:<input type='text' name='username' /><br /> Password:<input
			type='password' name='password' /><br /> <input type='submit'
			value='submit' />
	</form>
</body>
</html>
