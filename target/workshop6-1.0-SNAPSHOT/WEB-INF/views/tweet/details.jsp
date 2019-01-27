<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet details</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>Tweet ${tweet.id} details:</h3>
<p><b>Created by:</b> ${user} on ${tweet.created}</p>
<p><b>Title:</b> ${tweet.title}</p>
<p><b>Content:</b> ${tweet.tweetText}</p>
<p><b>Comments:</b>
<ul>
    <c:forEach items="${comments}" var="comment">
        <li><i>${comment.created}: <b>${comment.user}:</b> ${comment.text}</i></li>
    </c:forEach>
</ul></p>
<p><a href="${pageContext.request.contextPath}/">Get back home</a></p>
</body>
</html>
