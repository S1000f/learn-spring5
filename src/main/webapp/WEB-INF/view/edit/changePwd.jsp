<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="change.pwd.title" /></title>
</head>
<body>
    <p>
        <spring:message code="change.pwd.done" />
    </p>
    <p>
        <a href="<c:url value='/main' />">[<spring:message code="go.main" />]</a>
    </p>
</body>
</html>