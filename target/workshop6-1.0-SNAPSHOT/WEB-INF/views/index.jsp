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
<BR>
<c:choose>
    <c:when test="${empty sessionScope.user}">
        <a href="/login">No one logged in, click here</a>
    </c:when>
    <c:otherwise>
        ${sessionScope.user} logged in. Hi!
        <a href="user/tweets/${sessionScope.user.id}">Your tweets</a>
        <h3>Add new tweet!</h3>
        <form:form method="post" action="/tweet/save" modelAttribute="tweet">
            <form:hidden path="id"/>
            <form:hidden path="created"/>
            <form:hidden path="user" value="${sessionScope.user.id}"/>
            <form:input path="title" placeholder="Title"/>
            <form:errors path="title" cssStyle="color: darkred"/><BR><BR>
            <form:textarea path="tweetText" placeholder="Tweet Text" cols="50" rows="3"/>
            <form:errors path="tweetText" cssStyle="color: darkred"/><BR><BR>
            <form:errors path="user" cssStyle="color: darkred"/>
            <form:button>Submit</form:button>
        </form:form>
    </c:otherwise>
</c:choose>
<h3>The Tweets:</h3>
<c:forEach items="${allTweets}" var="tweet">
    <p><b>Title:</b> ${tweet.title}, <b>by:</b> ${tweet.user}</p>
    <p><b>Date:</b> ${tweet.created}, <a href="/tweet/details/${tweet.id}">details</a></td></p>
    <p><b>Text:</b> ${tweet.tweetText}</p>
    <hr>
</c:forEach>

</body>
</html>
