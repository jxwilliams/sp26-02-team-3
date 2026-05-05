<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Available Providers</title>
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
            margin-left: 16px;
        }

        .page {
            max-width: 1000px;
            margin: 30px auto;
            padding: 0 20px 30px 20px;
        }

        .card {
            background: white;
            border-radius: 10px;
            padding: 24px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #153e75;
            margin-top: 0;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 18px;
        }

        th, td {
            text-align: left;
            padding: 12px 10px;
            border-bottom: 1px solid #e5e7eb;
        }

        th {
            background: #eef4ff;
        }

        .button {
            background: #153e75;
            color: white;
            padding: 8px 12px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div>Available Providers</div>
    <div>
        <a href="/">Home</a>
        <a href="/customer">Customer Portal</a>
        <a href="/customer/logout">Logout</a>
    </div>
</div>

<div class="page">
    <div class="card">
        <h1>Available Doctors</h1>
        <p>Choose a provider to request an appointment, ${customerName}.</p>

        <table>
            <thead>
            <tr>
                <th>Provider</th>
                <th>Specialty</th>
                <th>What They Provide</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <#list providers as provider>
                <tr>
                    <td>${provider.name}</td>
                    <td>${provider.specialty}</td>
                    <td>${provider.specialty} appointments and pet care</td>
                    <td><a class="button" href="/customer/book?providerId=${provider.id}">Book</a></td>
                </tr>
            <#else>
                <tr>
                    <td colspan="4">No providers found.</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
