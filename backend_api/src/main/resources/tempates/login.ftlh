<!DOCTYPE html>
<html>
<head>
    <title>Provider Login</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Spartan Vet Provider Login</h1>

    <form action="/provider/login" method="post">
        <div>
            <label>Username:</label>
            <input type="text" name="username" required>
        </div>

        <br>

        <div>
            <label>Password:</label>
            <input type="password" name="password" required>
        </div>

        <br>

        <button type="submit">Log In</button>
    </form>

    <#if error??>
        <p style="color:red;">${error}</p>
    </#if>

    <p>Demo login: provider / pass</p>
</body>
</html>