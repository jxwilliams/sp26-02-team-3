<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Provider Dashboard</title>
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

        .action-form {
            display: inline-block;
            margin-right: 6px;
        }

        button {
            border: none;
            border-radius: 6px;
            padding: 8px 12px;
            cursor: pointer;
            color: white;
        }

        .accept-btn {
            background: #027a48;
        }

        .deny-btn {
            background: #b42318;
        }

        .disabled-btn {
            background: #98a2b3;
            cursor: not-allowed;
        }

        .message {
            margin-top: 12px;
            padding: 10px;
            border-radius: 6px;
            background: #ecfdf3;
            color: #027a48;
        }

        .error-message {
            margin-top: 12px;
            padding: 10px;
            border-radius: 6px;
            background: #fef3f2;
            color: #b42318;
        }

        .section-title {
            margin-top: 32px;
            color: #153e75;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div>Spartan Vet Provider Dashboard</div>
    <div>
        <a href="/">Home</a>
        <a href="/provider/logout">Logout</a>
    </div>
</div>

<div class="page">
    <div class="card">
        <h1>Welcome, ${provider.name}!</h1>
        <p>Specialty: ${provider.specialty}</p>
        <p>This page shows appointment requests and lets the provider accept or deny them.</p>

        <!-- I show this message after the provider updates a booking. -->
        <#if successMessage??>
            <div class="message">${successMessage}</div>
        </#if>

        <#if errorMessage??>
            <div class="error-message">${errorMessage}</div>
        </#if>

        <!-- I list the appointment requests that come from the database. -->
        <table>
            <thead>
            <tr>
                <th>Pet Name</th>
                <th>Customer</th>
                <th>Provider</th>
                <th>Service Type</th>
                <th>Appointment Date</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <#list bookings as booking>
                <!-- I default missing old statuses to Pending so the page does not crash. -->
                <#assign bookingStatus = (booking.status?has_content)?then(booking.status, "Pending")>
                <tr>
                    <td>${booking.petName}</td>
                    <td>${booking.customerName!"N/A"}</td>
                    <td>${booking.providerName!"N/A"}</td>
                    <td>${booking.serviceType}</td>
                    <td>${booking.appointmentDate}</td>
                    <td class="status
                        <#if bookingStatus == 'Pending'> pending</#if>
                        <#if bookingStatus == 'Accepted'> accepted</#if>
                        <#if bookingStatus == 'Denied'> denied</#if>">
                        ${bookingStatus}
                    </td>
                    <td>
                        <!-- I only let the provider change requests that are still Pending. -->
                        <#if bookingStatus == "Pending">
                            <form class="action-form" action="/provider/bookings/${booking.id}/status" method="post">
                                <input type="hidden" name="status" value="Accepted">
                                <button class="accept-btn" type="submit">Accept</button>
                            </form>
                            <form class="action-form" action="/provider/bookings/${booking.id}/status" method="post">
                                <input type="hidden" name="status" value="Denied">
                                <button class="deny-btn" type="submit">Deny</button>
                            </form>
                        <#else>
                            <button class="disabled-btn" type="button" disabled>Already Updated</button>
                        </#if>
                    </td>
                </tr>
            <#else>
                <tr>
                    <td colspan="7">No appointment requests found.</td>
                </tr>
            </#list>
            </tbody>
        </table>

        <h2 class="section-title">Customer Reviews</h2>
        <p>Recent customer feedback for the provider team.</p>

        <!-- I show customer reviews under the booking requests for the provider. -->
        <table>
            <thead>
            <tr>
                <th>Customer</th>
                <th>Rating</th>
                <th>Comment</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <#list reviews as review>
                <tr>
                    <td>${review.customerName!"Unknown"}</td>
                    <td>${review.rating!"N/A"}</td>
                    <td>${review.comment!"No comment"}</td>
                    <td>${review.reviewDate!"N/A"}</td>
                </tr>
            <#else>
                <tr>
                    <td colspan="4">No customer reviews found.</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
