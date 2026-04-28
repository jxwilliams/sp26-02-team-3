<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Appointment Status</title>
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

        label {
            display: block;
            margin-top: 14px;
            margin-bottom: 6px;
            font-weight: bold;
        }

        input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            width: 280px;
            max-width: 100%;
        }

        button {
            padding: 10px 14px;
            border: none;
            border-radius: 6px;
            background: #153e75;
            color: white;
            cursor: pointer;
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

        .status {
            font-weight: bold;
        }

        .pending {
            color: #b54708;
        }

        .accepted {
            color: #027a48;
        }

        .denied {
            color: #b42318;
        }

        .message {
            margin-top: 12px;
            padding: 10px;
            border-radius: 6px;
            background: #ecfdf3;
            color: #027a48;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div>Appointment Status</div>
    <div>
        <a href="/">Home</a>
        <a href="/customer">Customer Portal</a>
    </div>
</div>

<div class="page">
    <div class="card">
        <h1>Check Appointment Status</h1>

        <#if successMessage??>
            <div class="message">${successMessage}</div>
        </#if>

        <form action="/customer/status" method="get">
            <label for="customerName">Enter the same name used for booking</label>
            <input type="text" id="customerName" name="customerName" value="${customerName!""}" required>
            <button type="submit">Search</button>
        </form>

        <#if bookings??>
            <table>
                <thead>
                <tr>
                    <th>Pet Name</th>
                    <th>Provider</th>
                    <th>Service</th>
                    <th>Date</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <#list bookings as booking>
                    <#assign bookingStatus = (booking.status?has_content)?then(booking.status, "Pending")>
                    <tr>
                        <td>${booking.petName}</td>
                        <td>${booking.providerName!"N/A"}</td>
                        <td>${booking.serviceType}</td>
                        <td>${booking.appointmentDate}</td>
                        <td class="status
                            <#if bookingStatus == 'Pending'> pending</#if>
                            <#if bookingStatus == 'Accepted'> accepted</#if>
                            <#if bookingStatus == 'Denied'> denied</#if>">
                            ${bookingStatus}
                        </td>
                    </tr>
                <#else>
                    <tr>
                        <td colspan="5">No appointment requests found for that name.</td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </#if>
    </div>
</div>
</body>
</html>
