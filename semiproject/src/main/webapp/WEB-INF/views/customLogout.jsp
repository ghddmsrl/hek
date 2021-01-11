<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>로그아웃</title>
</head>
<body>

<h1>로그아웃 페이지</h1>

<form method='post' action="/customLogout">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }"/>
	<button>로그아웃</button>
</form>
</body>
</html>