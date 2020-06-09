<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Main</title>
</head>
<body>
    <c:if test="${empty authInfo}">
    <p>Welcome!<br />
    Log in or Sign up for new account</p>
    <p>
        <a href="<c:url value='/register/step1'/>">[register member]</a>
        <a href="<c:url value='/login'/>">[Log in]</a>
    </p>
    </c:if>

    <c:if test="${! empty authInfo}">
        <p>${authInfo.name}님, 환영합니다!</p>
        <p>
            <a href="<c:url value='/edit/changePassword'/>">[change password]</a>
            <a href="<c:url value='/logout'/>">[Log out]</a>
        </p>
    </c:if>
</body>
</html>