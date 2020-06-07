<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Example</title>
</head>
<body>
    <form:form modelAttribute="loginTypes">
    <p>
        <label for="loginTypes">Login Type</label>
        <form:select path="loginTypes">
            <form:options items="${loginTypes}"/>
        </form:select>
    </p>
    </form:form>
</body>
</html>