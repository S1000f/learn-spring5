<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 상세정보</title>
</head>
<body>
    <p>ID: ${member.id}</p>
    <p>email: ${member.email}</p>
    <p>name: ${member.name}</p>
    <p>registered date: <tf:formatDateTime value="${member.registerDateTime}" pattern="yyyy-MM-dd HH:mm" /></p>
</body>
</html>