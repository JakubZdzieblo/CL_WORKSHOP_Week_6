<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Index</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
Hi.
<BR>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <a href="/login">No one logged in, click here</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.user} logged in. Hi!
    </c:otherwise>
</c:choose>
</body>
</html>
