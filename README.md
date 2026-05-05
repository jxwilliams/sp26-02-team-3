# Spartan Vet

Spartan Vet is a full stack veterinary web application made for our class project. The goal of the project is to give different users their own part of the system so they can interact with the vet office through one connected site.

The app includes a landing page, customer section, provider section, and database connection. For Milestone 6, my main focus was the **Provider** side of the project.

## Project Purpose

The purpose of Spartan Vet is to make it easier for customers and providers to manage vet appointments and related information in one system.

Customers can:
- view available providers
- see what services providers offer
- request an appointment
- check the status of their request

Providers can:
- log in
- view appointment requests that were assigned to them
- accept or deny requests
- view customer reviews

## My Actor

My actor for this milestone was the **Provider**.

## My Main Use Cases

For my individual Milestone 6 presentation, my two main use cases were:

1. **Provider Login / Account Access**  
   The provider can log into the system and access the provider dashboard.

2. **Provider Views and Manages Appointment Requests**  
   The provider can view appointment requests assigned to them and accept or deny them. The updated status is saved in the database.

## Extra Features I Added / Worked On

Along with my main use cases, I also helped connect the site more so it felt like a complete web app.

Some extra parts included:
- landing page / home page
- provider dashboard
- provider reviews section
- customer flow for viewing providers
- customer appointment request status
- database connection with Neon PostgreSQL

## Tech Stack

This project was built with:

- Java
- Spring Boot
- Spring MVC
- FreeMarker
- PostgreSQL / Neon
- HTML
- CSS

## Project Structure

Main folders used in the repo:

- `mvc-app/` → main MVC application
- `backend_api/` → backend API work from earlier project stages
- `prototype/` → earlier prototype pages
- `docs/` → project documentation


Example flow:
- user opens a page
- controller handles the route
- service layer gets data
- controller puts data into the model
- FreeMarker template displays the data in the browser

## Provider Flow

The provider flow is the main part of my milestone work.

### Provider Login
The provider starts at the provider login page and enters their login information.  
If the login is correct, the provider is redirected to the dashboard.

### Provider Dashboard
On the provider dashboard, the provider can:
- see appointment requests
- view request details
- accept or deny a request
- see customer reviews

Each request has a status such as:
- Pending
- Accepted
- Denied

The status updates are saved in the database.

## Customer Flow

The customer side lets users:
- view available providers
- see provider specialties / services
- request an appointment
- check their appointment status

This connects with the provider side because the provider updates the request and the customer can later see that status.

## Database

This app uses **Neon PostgreSQL** for persistence.

The database stores important data such as:
- bookings / appointment requests
- providers
- customers
- reviews

Using Neon made the app use real persistent data instead of hardcoded sample data.

## Challenges I Faced

One challenge I faced was moving the project from separate prototype pages and backend API work into a real MVC application.

Instead of having disconnected parts, I had to connect:
- views
- controllers
- service logic
- database persistence

Another challenge was handling booking statuses after adding the new status field. Some older rows did not have a status yet, so I had to make sure missing values defaulted correctly.

## What I Learned

From this milestone I learned more about:
- Spring MVC structure
- FreeMarker templates
- connecting frontend pages to backend logic
- using a real PostgreSQL database
- passing data from controllers to views
- handling full stack project flow from UI to database

## How to Run the Project

Go into the `mvc-app` folder and run the Spring Boot app.

Example:

```bash
cd mvc-app
./mvnw spring-boot:run
