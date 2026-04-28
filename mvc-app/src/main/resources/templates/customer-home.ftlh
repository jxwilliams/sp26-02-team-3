<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Customer Portal</title>
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
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .top-bar a {
            color: white;
            text-decoration: none;
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

        .links {
            display: flex;
            flex-wrap: wrap;
            gap: 12px;
            margin-top: 24px;
        }

        .link-button {
            background: #153e75;
            color: white;
            padding: 12px 16px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div>Spartan Vet Customer Portal</div>
    <a href="/">Home</a>
</div>

<div class="page">
    <div class="card">
        <h1>Customer Portal</h1>
        <p>View providers, request an appointment, and check your appointment status.</p>

        <div class="links">
            <a class="link-button" href="/customer/providers">View Providers</a>
            <a class="link-button" href="/customer/book">Book Appointment</a>
            <a class="link-button" href="/customer/status">Check Status</a>
        </div>
    </div>
</div>
</body>
</html>
