<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>survey</title>
</head>
<body>
    <h2>survey</h2>
    <form action="" method="post">
    <c:forEach var="q" items="${questions}" varStatus="status">
        <p>
            ${status.index + 1}. ${q.title}<br />
            <c:if test="${q.choice}">
                <c:forEach var="option" items="${q.options}">
                    <label><input type="radio" name="responses[${status.index}]" value="${option}">
                    ${option}</label>
                </c:forEach>
            </c:if>
            <c:if test="${! q.choice }">
                <input type="text" name="responses[${status.index}]">
            </c:if>
        </p>
    </c:forEach>
        <p>
            <label for="">Location:<br />
            <input type="text" name="res.location">
            </label>
        </p>
        <p>
            <label for="">age:<br />
            <input type="text" name="res.age">
            </label>
        </p>
        <input type="submit" value="submit">
    </form>
</body>
</html>