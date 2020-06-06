<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>survey result</title>
</head>
<body>
    <p>survey result</p>
    <ul>
        <c:forEach var="response"
            items="${ansData.responses}" varStatus="status" >
        <li>${status.index + 1}Q: ${response}</li>
        </c:forEach>
    </ul>
    <p>Answer location: ${ansData.res.location}</p>
    <p>Answer age: ${ansData.res.age}</p>
</body>
</html>