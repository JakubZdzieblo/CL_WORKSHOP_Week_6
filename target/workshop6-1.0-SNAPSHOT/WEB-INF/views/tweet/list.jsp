<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tweet list</title>
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

<h3>List of tweets:</h3>
<table>
    <tr>
        <th>Created</th>
        <th>User</th>
        <th>Title</th>
        <th>Text</th>
        <th></th>
        <th></th>
    </tr>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <td>${tweet.created}</td>
            <td>${tweet.user}</td>
            <td>${tweet.title}</td>
            <td>${tweet.tweetText}</td>
            <td><a href="${pageContext.request.contextPath}/tweet/edit/${tweet.id}">EDIT</a></td>
            <td><a href="${pageContext.request.contextPath}/tweet/delete/${tweet.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/tweet/add">Add new tweet</a></p>
<p><a href="${pageContext.request.contextPath}">Get back home</a></p>
