<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            margin: 0;
            padding: 40px 20px;
        }

        .login-box {
            max-width: 420px;
            margin: 60px auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.12);
        }

        h1 {
            margin-top: 0;
            color: #153e75;
        }

        p {
            color: #555;
        }

        label {
            display: block;
            margin-top: 14px;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            margin-top: 18px;
            padding: 12px;
            border: none;
            border-radius: 6px;
            background: #153e75;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        .error {
            margin-top: 12px;
            color: #b42318;
            background: #fef3f2;
            padding: 10px;
            border-radius: 6px;
        }

        .home-link {
            display: inline-block;
            margin-bottom: 18px;
            color: #153e75;
            font-weight: bold;
            text-decoration: none;
        }
    </style>
</head>
<body>
<div class="login-box">
    <a class="home-link" href="/">Back to Home</a>
    <h1>Customer Login</h1>
    <p>Sign in to request appointments and check your status.</p>

    <form action="/customer/login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
    </form>

    <#if errorMessage??>
        <div class="error">${errorMessage}</div>
    </#if>

    <p>Need an account? <a href="/customer/register">Register here</a>.</p>
</div>
</body>
</html>
