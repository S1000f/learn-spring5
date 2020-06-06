<%@ page contentType="text/html; charset=utf-8" %>

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
        <p>
            1. What is your speciality<br />
            <label for=""><input type="radio" name="responses[0]" value="server">Server side</label>
            <label for=""><input type="radio" name="responses[0]" value="front">Front side</label>
            <label for=""><input type="radio" name="responses[0]" value="fullstack">Full stack</label>
        </p>
        <p>
            2. What is your favorite tool<br />
            <label for=""><input type="radio" name="responses[1]" value="Eclipse">Eclipse</label>
            <label for=""><input type="radio" name="responses[1]" value="Intellij">IntelliJ</label>
            <label for=""><input type="radio" name="responses[1]" value="Sublime">Sublime Text</label>
        </p>
        <p>
            3. Any comment<br />
            <input type="text" name="responses[2]">
        </p>
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