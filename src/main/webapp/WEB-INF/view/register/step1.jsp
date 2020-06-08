<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="member.register" /></title>
</head>
<body>
    <h2><spring:message code="term" /></h2>
    <p>if you agree with the terms of the service, please check agree and <br />
    click the next button to sign-up...
    </p>
    <form action="step2" method="post" >
    <label>
        <input type="checkbox" name="agree" value="true">
        <spring:message code="term.agree" />
    </label>
    <input type="submit" value="<spring:message code="next.btn" />" />
    </form>
</body>
</html>