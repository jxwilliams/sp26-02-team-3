<!DOCTYPE html>
<html>
<head>
    <title>Provider Dashboard</title>
    <meta charset="UTF-8">
</head>
<body>
    <h1>Provider Dashboard</h1>
    <p>View appointment requests and update their status.</p>

    <!-- I show a simple message if there are no bookings yet. -->
    <#if bookings?size == 0>
        <p>No appointment requests found.</p>
    <#else>
        <!-- I use this table so the provider can review each appointment request. -->
        <table border="1" cellpadding="8">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Pet Name</th>
                    <th>Service Type</th>
                    <th>Appointment Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <#list bookings as booking>
                    <!-- Each row is one booking from the database. -->
                    <tr>
                        <td>${booking.id}</td>
                        <td>${booking.petName}</td>
                        <td>${booking.serviceType}</td>
                        <td>${booking.appointmentDate}</td>
                        <td>${booking.status}</td>
                        <td>
                            <!-- This form lets the provider accept the booking. -->
                            <form action="/provider/bookings/${booking.id}/status" method="post" style="display:inline;">
                                <input type="hidden" name="status" value="Accepted">
                                <button type="submit">Accept</button>
                            </form>

                            <!-- This form lets the provider deny the booking. -->
                            <form action="/provider/bookings/${booking.id}/status" method="post" style="display:inline;">
                                <input type="hidden" name="status" value="Denied">
                                <button type="submit">Deny</button>
                            </form>
                        </td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </#if>
</body>
</html>
