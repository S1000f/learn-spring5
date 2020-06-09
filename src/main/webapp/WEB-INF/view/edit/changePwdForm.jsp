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
    <form:form>
        <p>
            <label for=""><spring:message code="currentPassword" />:<br />
            <form:input path="currentPassword" />
            <form:errors path="currentPassword" />
            </label>
        </p>
        <p>
            <label for=""><spring:message code="newPassword" />:<br />
            <form:password path="newPassword" />
            <form:errors path="newPassword" />
            </label>
        </p>
        <input type="submit" value="<spring:message code='change.btn' />">
    </form:form>
</body>
</html>