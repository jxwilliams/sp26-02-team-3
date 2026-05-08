# Spartan Vet SRS Document

**Project Name:** Spartan Vet  
**Team:** Natalie Adkins and Jowuan Williams  
**Course:** CSC 340  
**Version:** 2.0  
**Date:** Spring 2026  

---

## 1. Overview

### Project Vision

Spartan Vet is a veterinary web application made for students and people around the UNCG area who own pets. The goal of the project is to make it easier for customers to view providers, request appointments, and check their appointment status.

The project also gives providers their own side of the system. Providers can log in, view appointment requests, accept or deny requests, and view customer reviews.

### Project Purpose

The purpose of this project is to connect customers and veterinary providers in one system. Instead of only having static pages, the final version uses a Spring MVC app with pages, controllers, services, and a PostgreSQL/Neon database.

### Primary Users / Roles

- **Customer:** A pet owner who wants to view providers, request an appointment, and check their appointment status.
- **Provider:** A vet office or service provider who wants to log in, view appointment requests, and accept or deny them.
- **Admin:** A system role that could manage users and accounts. This was planned, but it was not the main focus of the final implementation.

### Scope for This Semester

For this semester, our project focused on these main features:

- customer can view available providers
- customer can request an appointment
- customer can check the status of an appointment request
- provider can log in
- provider can view appointment requests
- provider can accept or deny appointment requests
- provider can view customer reviews
- data is stored using PostgreSQL/Neon

### Out of Scope

These features are not part of the final main implementation:

- real-time messaging between customers and providers
- emergency vet services
- payments
- insurance processing
- full admin dashboard
- mobile app version

---

## 2. Functional Requirements

## 2.1 Customer Stories

### US-CUST-001 — Customer Views Providers

**Story:**  
As a customer, I want to view available providers so that I can choose a vet service for my pet.

**Acceptance:**


Scenario: Customer views providers
Given the customer is on the website
When the customer opens the provider page
Then the customer should see a list of available providers


### US-CUST-002 — Customer Views Provider Information

**Story:**
As a customer, I want to see provider information so that I can decide which provider I want to request an appointment with.

**Acceptance:**

Scenario: Customer views provider details

Given the customer is viewing the provider list  
When the customer chooses a provider  
Then the customer should be able to see provider information and services

### US-CUST-003 — Customer Requests Appointment
Story:
As a customer, I want to request an appointment so that I can get service from a provider.

Acceptance:

Scenario: Customer requests an appointment
Given the customer is viewing a provider
When the customer fills out the appointment request form
Then the appointment request should be saved with a pending status
US-CUST-004 — Customer Checks Appointment Status

Story:
As a customer, I want to check my appointment status so that I know if my request was accepted or denied.

Acceptance:

Scenario: Customer checks appointment status
Given the customer has submitted an appointment request
When the customer opens the status page
Then the customer should see if the request is pending, accepted, or denied
2.2 Provider Stories
US-PROV-001 — Provider Login

Story:
As a provider, I want to log in to my account so that I can access my provider dashboard.

Acceptance:

Scenario: Provider logs in
Given the provider has an account
When the provider enters valid login information
Then the provider should be sent to the provider dashboard
US-PROV-002 — Provider Views Appointment Requests

Story:
As a provider, I want to view pending appointment requests so that I can manage customer appointments.

Acceptance:

Scenario: Provider views requests
Given the provider is logged in
When the provider opens the dashboard
Then the provider should see appointment requests assigned to them
US-PROV-003 — Provider Accepts Appointment Request

Story:
As a provider, I want to accept an appointment request so that the customer knows the appointment was approved.

Acceptance:

Scenario: Provider accepts request
Given the provider is viewing a pending appointment request
When the provider clicks accept
Then the appointment status should update to accepted
US-PROV-004 — Provider Denies Appointment Request

Story:
As a provider, I want to deny an appointment request so that the customer knows the appointment was not approved.

Acceptance:

Scenario: Provider denies request
Given the provider is viewing a pending appointment request
When the provider clicks deny
Then the appointment status should update to denied
US-PROV-005 — Provider Views Customer Reviews

Story:
As a provider, I want to view customer reviews so that I can see feedback from customers.

Acceptance:

Scenario: Provider views reviews
Given the provider is on the dashboard
When the provider opens the reviews section
Then the provider should see customer reviews
2.3 Admin Stories
US-ADMIN-001 — Admin Views Users

Story:
As an admin, I want to view users so that I can manage accounts.

Acceptance:

Scenario: Admin views users
Given the admin is logged in
When the admin opens the user management page
Then the admin should see a list of users

Status:
This was planned, but it was not a main final feature.

US-ADMIN-002 — Admin Disables User Account

Story:
As an admin, I want to disable a user account so that I can handle account problems.

Acceptance:

Scenario: Admin disables user
Given the admin is viewing a user account
When the admin disables the account
Then the user should no longer be able to access the system

Status:
This was planned, but it was not a main final feature.

3. Non-Functional Requirements
Performance
The website should load in less than 5 seconds under normal use.
The provider dashboard should load appointment requests without a long delay.
Appointment status updates should save quickly after a provider accepts or denies a request.
The app should be able to handle multiple users using the system during testing.
Availability / Reliability
The system should be available during normal class testing and demo use.
The app should keep appointment request data stored in the database.
If the app is restarted, the stored provider, customer, appointment, and review data should still be available.
Security / Privacy
Provider login should only allow the correct provider to access the dashboard.
User and provider information should not be shown to people who should not have access.
Database credentials should not be hardcoded in public files.
Sensitive configuration information should be kept out of GitHub when possible.
Usability
The website should be easy to navigate.
Customers should be able to request an appointment without needing too many steps.
Providers should be able to accept or deny requests from the dashboard.
Pages should have clear labels and buttons.
The app should work on a normal desktop browser.
Maintainability
The project should be organized using MVC structure.
Controllers should handle routes.
Services should handle main logic.
Views should handle what the user sees.
Database logic should be separated from the page templates.
4. Assumptions, Constraints, and Policies
Assumptions
The user has access to the internet.
The user can use a web browser.
Customers know basic information needed to request an appointment.
Providers are responsible for checking and updating their appointment requests.
The database connection is available when the app is running.
Constraints
The project had to be completed during the semester.
The scope was limited because this was a class project.
The final app mainly focuses on the MVC implementation and required use cases.
Some features from the original idea were simplified or left out.
The project uses the tools and languages required for the course.
Policies
User data should not be shared without permission.
Provider access should be protected.
Database credentials should be kept private.
Changes to requirements should be updated in the SRS.
Final documentation should match what was actually implemented.
5. Milestones
M2 — Requirements

We created the original SRS and wrote the first user stories.

M3 — Prototype

We created prototype pages for the customer and provider flows.

M4 — Design

We planned the project structure, database ideas, and system design.

M5 — Backend API

We worked on backend API features and database connection.

M6 — Increment

We built end-to-end use cases. My main focus was the provider side, including provider login and provider appointment request management.

M7 — Final

We updated the final project documentation, completed the MVC app, connected the use cases to the final implementation, and prepared the repository for submission.

6. Change Management

This SRS was updated to match the final version of Spartan Vet. Some earlier ideas changed as the project moved from prototype pages and backend API work into the Spring MVC app.

The main final changes were:

provider login was added as a main use case
provider dashboard became a main feature
appointment requests were connected to status updates
customers could check appointment status
PostgreSQL/Neon was used for persistent data
admin features were listed as planned but not main final features
