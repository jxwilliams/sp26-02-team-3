<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spartan Vet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f7fb;
            margin: 0;
            padding: 0;
        }

        .top-bar {
            background: #153e75;
            color: white;
            padding: 16px 24px;
            font-weight: bold;
        }

        .page {
            max-width: 900px;
            margin: 40px auto;
            padding: 0 20px;
        }

        .card {
            background: white;
            border-radius: 10px;
            padding: 28px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #153e75;
            margin-top: 0;
        }

        p {
            color: #555;
            line-height: 1.5;
        }

        .portal-links {
            display: flex;
            flex-wrap: wrap;
            gap: 12px;
            margin-top: 24px;
        }

        .portal-link {
            background: #153e75;
            color: white;
            padding: 12px 16px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
        }

        .secondary-link {
            background: #eef4ff;
            color: #153e75;
        }
    </style>
</head>
<body>
<div class="top-bar">Spartan Vet</div>

<div class="page">
    <div class="card">
        <h1>Spartan Vet</h1>
        <p>Welcome to Spartan Vet. Use the portal links below to open the correct area for your role.</p>

        <div class="portal-links">
            <a class="portal-link" href="/provider/login">Provider Portal</a>
            <a class="portal-link secondary-link" href="/customer">Customer Portal</a>
            <a class="portal-link secondary-link" href="/admin">Admin Portal</a>
        </div>
    </div>
</div>
</body>
</html>
