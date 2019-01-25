<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
Hi!

<H3>Zadanie 3</H3>
<a href="/user/1/tweets">Tweets by user 1</a><br>
<a href="/user/2/tweets">Tweets by user 2</a><br>
<a href="/user/3/tweets">Tweets by user 3</a><br>
<br>
<a href="/user/search-tweets?title=All">Tweets with title starting with "All"</a><br>
<a href="/user/search-tweets?title=Flow">Tweets with title starting with "Flow"</a><br>
</body>
</html>
