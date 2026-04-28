<!DOCTYPE html>
<html>
<head>
    <title>Provider Login</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Spartan Vet Provider Login</h1>

    <!-- I use this form so the provider can log in before seeing bookings. -->
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

    <!-- If the login fails, I show the error message here. -->
    <#if error??>
        <p style="color:red;">${error}</p>
    </#if>

    <!-- This is the demo account for testing my provider flow. -->
    <p>Demo login: provider / pass</p>
</body>
</html>
