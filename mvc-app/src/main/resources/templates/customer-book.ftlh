<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Appointment</title>
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
            max-width: 700px;
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

        input, select {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        button {
            margin-top: 18px;
            padding: 12px 16px;
            border: none;
            border-radius: 6px;
            background: #153e75;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="top-bar">
    <div>Book Appointment</div>
    <div>
        <a href="/">Home</a>
        <a href="/customer">Customer Portal</a>
        <a href="/customer/logout">Logout</a>
    </div>
</div>

<div class="page">
    <div class="card">
        <h1>Request an Appointment</h1>
        <p>Your request will start as Pending until a provider accepts or denies it.</p>

        <#if errorMessage??>
            <p style="color: #b42318; font-weight: bold;">${errorMessage}</p>
        </#if>

        <form action="/customer/book" method="post">
            <label for="customerName">Your Name</label>
            <input type="text" id="customerName" value="${customerName}" readonly>

            <label for="petName">Pet Name</label>
            <input type="text" id="petName" name="petName" required>

            <label for="providerId">Provider</label>
            <select id="providerId" name="providerId" required>
                <#list providers as provider>
                    <option value="${provider.id}" <#if selectedProvider?? && selectedProvider.id == provider.id>selected</#if>>
                        ${provider.name} - ${provider.specialty}
                    </option>
                </#list>
            </select>

            <label for="serviceType">Service Needed</label>
            <select id="serviceType" name="serviceType" required>
                <#if selectedProvider??>
                    <option value="${selectedProvider.specialty}" selected>${selectedProvider.specialty}</option>
                </#if>
                <option value="Checkup">Checkup</option>
                <option value="Vaccination">Vaccination</option>
                <option value="Dental Cleaning">Dental Cleaning</option>
                <option value="General Care">General Care</option>
            </select>

            <label for="appointmentDate">Requested Date</label>
            <input type="date" id="appointmentDate" name="appointmentDate" required>

            <button type="submit">Send Request</button>
        </form>
    </div>
</div>
</body>
</html>
