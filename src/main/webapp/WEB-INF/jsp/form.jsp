<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
    <form:form action="/book" method="post" modelAttribute="book">
        <form:input path="title"/>
        <form:input path="price"/>
        <button type="submit">Add</button>
    </form:form>
</body>
</html>