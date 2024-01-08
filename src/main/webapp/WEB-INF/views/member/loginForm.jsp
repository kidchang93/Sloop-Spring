<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h2><c:out value="${error}"/></h2>
<form action="/login" method="post">
    <input type="text" name="username" placeholder="이메일"><br>
    <input type="password" name="password" placeholder="비밀번호"><br>
    <input type="submit" value="로그인">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
</form>
<a href="/register">회원가입하러가기</a>
</body>

</html>
