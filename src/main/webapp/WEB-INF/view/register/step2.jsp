<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Member</title>
</head>
<body>
    <h2>Member info
        <form action="step3" method="POST">
            <p>
                <label for="">email:<br />
                <input type="text" name="email" id="email">
                </label>
            </p>
            <p>
                <label>name:<br />
                <input type="text" name="name" id="name">
                </label>
            </p>
            <p>
                <label>password:<br />
                <input type="password" name="password" id="password">
                </label>
            </p>
            <p>
                <label>password confirm:<br />
                <input type="password" name="confirmPassword" id="confirmPassword" >
                </label>
            </p>
            <input type="submit" value="sign up">
        </form>
    </h2>
</body>
</html>