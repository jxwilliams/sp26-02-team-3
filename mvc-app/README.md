# Spartan Vet MVC Implementation

This folder has the MVC version of our Spartan Vet project. This part of the project shows how we connected our use cases to the actual code.

The app uses the MVC setup:

- Model: holds the data for things like providers, customers, appointments, and reviews.
- View: shows the pages to the user.
- Controller: handles the routes and connects the pages to the backend logic.
- Service: handles the main logic.
- Repository/Database: stores and gets the data from the database.

## Use Case Mapping

### UC-1: Provider Login

In this use case, the provider can log in so they can access their dashboard.

For this, I used a controller to handle the login route. The view shows the login form, and the service checks the provider information. If the login is correct, the provider is sent to the dashboard.

Basic flow:

1. The provider opens the login page.
2. The provider enters their login information.
3. The controller receives the login request.
4. The service checks the login information.
5. If it is correct, the provider goes to the dashboard.

### UC-2: Provider Views Appointment Requests

In this use case, the provider can view appointment requests that customers sent in.

For this, I used the provider dashboard to show the appointment requests. The controller gets the requests from the service, and the service gets the data from the database.

Basic flow:

1. The provider opens the dashboard.
2. The controller asks for the appointment requests.
3. The service gets the request data.
4. The page displays the requests to the provider.

### UC-3: Provider Accepts or Denies Appointment Requests

In this use case, the provider can accept or deny customer appointment requests.

For this, I added actions for accepting and denying requests. When the provider clicks one of these options, the controller sends the update to the service. Then the database saves the new status.

Basic flow:

1. The provider views a pending request.
2. The provider clicks accept or deny.
3. The controller receives the action.
4. The service updates the request.
5. The database saves the new status.
6. The dashboard shows the updated request.

### UC-4: Customer Views Providers

In this use case, the customer can view providers before making an appointment request.

For this, I used a page that lists the providers. The controller gets the provider data from the service, and the view displays it for the customer.

Basic flow:

1. The customer opens the provider page.
2. The controller asks for the provider data.
3. The service gets the providers.
4. The page displays the providers.

### UC-5: Customer Requests Appointment

In this use case, the customer can request an appointment with a provider.

For this, I used a form where the customer can enter the appointment information. The controller receives the form data and sends it to the service. Then the request is saved in the database with a pending status.

Basic flow:

1. The customer selects a provider.
2. The customer fills out the appointment request form.
3. The controller receives the form.
4. The service saves the request.
5. The database stores it as pending.

### UC-6: Customer Checks Appointment Status

In this use case, the customer can check if their appointment request is pending, accepted, or denied.

For this, I used a status page that gets the appointment information from the database. The service gets the current status, and the view shows it to the customer.

Basic flow:

1. The customer opens the status page.
2. The controller asks for the appointment information.
3. The service gets the current status.
4. The page displays the status.

## Database

The MVC app uses PostgreSQL/Neon to store the project data. The database stores things like:

- Providers
- Customers
- Appointment requests
- Reviews
- Appointment statuses

## How to Run

From the main project folder:

```bash
cd mvc-app
./mvnw spring-boot:run
