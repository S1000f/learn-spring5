<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Member</title>
</head>
<body>
    <h2>Member info</h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label>Email:<br />
            <form:input path="email" />
            </label>
        </p>
        <p>
            <label>Name:<br />
            <form:input path="name" />
            </label>
        </p>
        <p>
            <label>Password:<br />
            <form:password path="password" />
            </label>
        </p>
        <p>
            <label>Confirm password:<br />
            <form:password path="confirmPassword" />
            </label>
        </p>
        <input type="submit" value="Sign up">
    </form:form>
</body>
</html>