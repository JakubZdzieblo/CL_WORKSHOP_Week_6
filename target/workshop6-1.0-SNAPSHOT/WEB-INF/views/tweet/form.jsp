<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Tweet form</title>
    <style>
        body{
            font-family: sans-serif;
        }
    </style>
</head>
<body>
<h3>Please fill in tweet details</h3>
<form:form method="post" action="/tweet/save" modelAttribute="tweet">
    <form:hidden path="id"/>
    <form:hidden path="created"/>
    <form:select path="user" cssStyle="width: 150px">
        <form:option value="0" label="Choose user" selected="true" disabled="true"/>
        <form:options items="${users}" itemValue="id" itemLabel="name"/>
    </form:select>
    <form:errors path="user" cssClass="alert alert-danger"/><BR><BR>
    <form:input path="title" placeholder="Title"/>
    <form:errors path="title" cssStyle="color: darkred"/><BR><BR>
    <form:textarea path="tweetText" placeholder="Tweet Text" cols="50" rows="3"/>
    <form:errors path="tweetText" cssStyle="color: darkred"/><BR><BR>
    <form:button>Submit</form:button>
</form:form>
</body>
</html>
