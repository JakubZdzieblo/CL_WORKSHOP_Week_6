<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User list</title>
    <style>
        body{
            font-family: sans-serif;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {background-color: #f2f2f2;}
    </style>
</head>
<body>

<h3>List of users:</h3>
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
        <td>${user}</td>
        <td>${user.email}</td>
        <td><a href="/user/${user.id}/tweets">List of tweets</a></td>
        <td><a href="${pageContext.request.contextPath}/user/edit/${user.id}">EDIT</a></td>
        <td><a href="${pageContext.request.contextPath}/user/delete/${user.id}">DELETE</a></td>
    </tr>
    </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/user/add">Add new user</a></p>
<p><a href="${pageContext.request.contextPath}">Get back home</a></p>

</body>
</html>
