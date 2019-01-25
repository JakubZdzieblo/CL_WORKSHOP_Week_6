<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweets</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>Found Tweets:</h3>

<c:forEach items="${tweets}" var="tweet">
    <p><b>Title:</b> ${tweet.title}</p>
    <p><b>Date:</b> ${tweet.created}:</p>
    <p><b>Text:</b> ${tweet.tweetText}</p>
    <hr>
</c:forEach>

<a href="/home">Get back home</a>
</body>
</html>
