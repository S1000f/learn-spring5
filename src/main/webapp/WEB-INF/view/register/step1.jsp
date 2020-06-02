<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h2>The Terms of the Service</h2>
    <p>if you agree with the terms of the service, please check agree and <br />
    click the next button to sign-up...
    </p>
    <form action="step2" method="post" >
    <label>
        <input type="checkbox" name="agree" value="true">agree
    </label>
    <input type="submit" value="next" />
    </form>
</body>
</html>