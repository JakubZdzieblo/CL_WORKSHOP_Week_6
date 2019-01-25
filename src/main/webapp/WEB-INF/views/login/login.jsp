<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Login form</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>LOGIN</h3>
<form:form method="post" action="/login/check" modelAttribute="user">
    <form:input path="username" placeholder="Login"/>
    <form:errors path="username" cssStyle="color: darkred"/><BR><BR>
    <form:password path="password" placeholder="Password"/>
    <form:errors path="password" cssStyle="color: darkred"/><BR><BR>
    <form:button>Submit</form:button>
</form:form>
<h3><a href="/login/register">REGISTER NEW USER</a></h3>
</body>
</html>