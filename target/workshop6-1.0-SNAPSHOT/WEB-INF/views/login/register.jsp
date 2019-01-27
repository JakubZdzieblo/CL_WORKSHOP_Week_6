<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Register</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>Please fill in the form below</h3>
<form:form method="post" action="/login/save" modelAttribute="user">
    <form:hidden path="enabled" value="true"/>
    <form:input path="username" placeholder="Login"/>
    <form:errors path="username" cssStyle="color: darkred"/><BR><BR>
    <form:password path="password" placeholder="Password"/>
    <form:errors path="password" cssStyle="color: darkred"/><BR><BR>
    <input type="password" name="repeatedPassword" placeholder="Repeat password"/>
    <span Style="color: darkred">${error}</span><BR><BR>
    <form:input path="email" placeholder="Email"/>
    <form:errors path="email" cssStyle="color: darkred"/><BR><BR>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
