<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Spartan Vet</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: aliceblue;
            color: darkslategray;
            margin: 0;
            padding: 0;
        }

        .top-bar {
            background: white;
            box-shadow: 0 2px 10px lightgray;
            position: sticky;
            top: 0;
            z-index: 10;
        }

        .nav {
            max-width: 1100px;
            margin: 0 auto;
            padding: 16px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 16px;
        }

        .brand {
            color: navy;
            font-size: 22px;
            font-weight: bold;
            text-decoration: none;
        }

        .nav-links {
            display: flex;
            flex-wrap: wrap;
            justify-content: flex-end;
            gap: 10px;
        }

        .nav-links a {
            color: darkslategray;
            text-decoration: none;
            font-weight: bold;
            padding: 8px 10px;
            border-radius: 6px;
        }

        .nav-links a:hover {
            background: aliceblue;
            color: navy;
        }

        .hero {
            min-height: 72vh;
            background-image: linear-gradient(to right, darkslategray, transparent), url("/images/spartan-vet-hero.jpg");
            background-position: center;
            background-size: cover;
            display: flex;
            align-items: center;
        }

        .hero-content {
            max-width: 1100px;
            width: 100%;
            margin: 0 auto;
            padding: 80px 20px;
        }

        .hero-text {
            max-width: 620px;
            color: white;
        }

        .hero-text h1 {
            font-size: 56px;
            line-height: 1.05;
            margin: 0 0 18px 0;
        }

        .hero-text p {
            font-size: 20px;
            line-height: 1.6;
            margin: 0;
        }

        .buttons {
            display: flex;
            flex-wrap: wrap;
            gap: 12px;
            margin-top: 28px;
        }

        .button {
            background: seagreen;
            color: white;
            padding: 13px 18px;
            border-radius: 6px;
            text-decoration: none;
            font-weight: bold;
            display: inline-block;
        }

        .button.secondary {
            background: white;
            color: navy;
        }

        .section {
            padding: 54px 20px;
        }

        .section.white {
            background: white;
        }

        .section-inner {
            max-width: 1100px;
            margin: 0 auto;
        }

        .section h2 {
            color: navy;
            font-size: 34px;
            margin: 0 0 12px 0;
        }

        .section p {
            color: dimgray;
            font-size: 17px;
            line-height: 1.6;
            margin: 0;
        }

        .intro {
            max-width: 760px;
        }

        .feature-grid {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 18px;
            margin-top: 28px;
        }

        .feature-card {
            background: white;
            border: 1px solid gainsboro;
            border-radius: 8px;
            padding: 22px;
            box-shadow: 0 8px 20px lightgray;
        }

        .feature-card h3 {
            color: navy;
            margin: 0 0 10px 0;
            font-size: 21px;
        }

        .feature-card p {
            font-size: 16px;
        }

        .callout {
            background: navy;
            color: white;
            border-radius: 8px;
            padding: 30px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            gap: 24px;
        }

        .callout h2 {
            color: white;
        }

        .callout p {
            color: lavender;
        }

        .footer {
            background: white;
            color: dimgray;
            padding: 18px 20px;
            text-align: center;
            font-size: 14px;
        }

        .footer a {
            color: navy;
        }

        @media (max-width: 760px) {
            .nav {
                align-items: flex-start;
                flex-direction: column;
            }

            .nav-links {
                justify-content: flex-start;
            }

            .hero {
                min-height: 68vh;
                background-image: linear-gradient(to bottom, darkslategray, transparent), url("/images/spartan-vet-hero.jpg");
            }

            .hero-text h1 {
                font-size: 40px;
            }

            .hero-text p {
                font-size: 18px;
            }

            .feature-grid {
                grid-template-columns: 1fr;
            }

            .callout {
                align-items: flex-start;
                flex-direction: column;
            }
        }
    </style>
</head>
<body>
<header class="top-bar">
    <nav class="nav">
        <a class="brand" href="/">Spartan Vet</a>
        <div class="nav-links">
            <a href="/customer">Customer Portal</a>
            <a href="/provider/login">Provider Login</a>
            <a href="/admin">Admin</a>
        </div>
    </nav>
</header>

<main>
    <section class="hero">
        <div class="hero-content">
            <div class="hero-text">
                <h1>Pet care made simple.</h1>
                <p>Spartan Vet helps customers book appointments and helps providers manage requests.</p>

                <div class="buttons">
                    <a class="button" href="/customer">Start as Customer</a>
                    <a class="button secondary" href="/provider/login">Provider Login</a>
                </div>
            </div>
        </div>
    </section>

    <section class="section white">
        <div class="section-inner intro">
            <h2>What Spartan Vet does</h2>
            <p>Customers can sign in, pick a provider, and request an appointment. Providers can sign in and manage their own appointment requests.</p>
        </div>
    </section>

    <section class="section">
        <div class="section-inner">
            <h2>Main features</h2>
            <p>The app keeps the booking process easy to follow.</p>

            <div class="feature-grid">
                <div class="feature-card">
                    <h3>Book appointments</h3>
                    <p>Customers can choose a provider and send an appointment request.</p>
                </div>

                <div class="feature-card">
                    <h3>Manage requests</h3>
                    <p>Providers can see their own requests and accept or deny them.</p>
                </div>

                <div class="feature-card">
                    <h3>Save information</h3>
                    <p>Accounts, bookings, reviews, and status updates are saved in the database.</p>
                </div>
            </div>
        </div>
    </section>

    <section class="section white">
        <div class="section-inner">
            <div class="callout">
                <div>
                    <h2>Ready to start?</h2>
                    <p>Use the customer portal to book an appointment, or sign in as a provider.</p>
                </div>
                <div class="buttons">
                    <a class="button" href="/customer">Customer Portal</a>
                    <a class="button secondary" href="/provider/login">Provider Login</a>
                </div>
            </div>
        </div>
    </section>
</main>

<footer class="footer">
    Spartan Vet MVC App. Photo by <a href="https://unsplash.com/photos/veterinarian-examines-a-dog-on-an-examination-table-I3KxEBS6iOc">Alexander Mass</a> on Unsplash.
</footer>
</body>
</html>
