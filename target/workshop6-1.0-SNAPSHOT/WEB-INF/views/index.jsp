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
Hi. Home page here.
<BR>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <a href="/login">No one logged in, click here</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.user} logged in. Hi!
    </c:otherwise>
</c:choose>
<h3>The Tweets:</h3>
<c:forEach items="${tweets}" var="tweet">
    <p><b>Title:</b> ${tweet.title}, <b>by:</b> ${tweet.user}</p>
    <p><b>Date:</b> ${tweet.created}:</p>
    <p><b>Text:</b> ${tweet.tweetText}</p>
    <hr>
</c:forEach>

</body>
</html>
