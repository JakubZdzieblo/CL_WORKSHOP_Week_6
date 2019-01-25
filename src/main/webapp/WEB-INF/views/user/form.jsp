<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User form</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>Please fill in user details</h3>
<form:form method="post" action="/user/save" modelAttribute="user">
    <form:hidden path="id"/>
    <form:input path="firstName" placeholder="First Name"/>
    <form:errors path="firstName" cssStyle="color: darkred"/><BR><BR>
    <form:input path="lastName" placeholder="Last Name"/>
    <form:errors path="lastName" cssStyle="color: darkred"/><BR><BR>
    <form:input path="email" placeholder="Email"/>
    <form:errors path="email" cssStyle="color: darkred"/><BR><BR>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
