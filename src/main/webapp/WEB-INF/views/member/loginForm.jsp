<<<<<<< HEAD
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>>>>>>> 9d56208400e79419e2ac9918c6dd9bab1efe6bd0
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<form action="/member/login" method="post">
    <input type="text" name="memberEmail" placeholder="이메일"><br>
    <input type="text" name="memberPassword" placeholder="비밀번호"><br>
    <input type="submit" value="로그인">
</form>
<a href="/member/signup">회원가입하러가기</a>
</body>

</html>
