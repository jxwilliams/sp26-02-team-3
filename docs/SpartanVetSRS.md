
# Requirements – Starter Template

**Project Name:** SpartanVet \
**Team:** Natalie Adkins(create customer) Jowuan Williams(create provider) \
**Course:** CSC 340\
**Version:** 1.0\
**Date:** 2026-02-12

---

## 1. Overview
**Vision.** This website is intended to be used by students on or around the UNCG campus who own pets. Its purpose will be to provide information on vet offices located nearby and provide services like making an appointment. 

**Glossary** Terms used in the project
- **Term 1:** description.
- **Term 2:** description

**Primary Users / Roles.**
- **Customer- Pet Owners** — Be able to locate offices, make appointments, and seek help through messaging.
- **Provider (e.g., Teacher/Doctor/Pet Sitter/etc. )** — 1 line goal statement.


**Scope (this semester).**
- create website that can locate veternarian offices
- website allows user to make appointments and locate an office
- website allows provider to accept/deny appointments
- website allows user to contact the offices/ see contact info
- website allows provider to contact customer

**Out of scope (deferred).**
- messaging between other clients
- messaging between different vet offices
- emergency services


> This document is **requirements‑level** and solution‑neutral; design decisions (UI layouts, API endpoints, schemas) are documented separately.

---

## 2. Functional Requirements (User Stories)
Write each story as: **As a `<role>`, I want `<capability>`, so that `<benefit>`.** Each story includes at least one **Given/When/Then** scenario.

### 2.1 Customer Stories
- **US‑CUST‑001 — <Create Profile>**  
  _Story:_ As a customer, I want to create a profile so that I can make an appointment. 
  _Acceptance:_
  ```gherkin
  Scenario: Creating a profile
    Given I create a profile
    When  I load in to the website
    Then  I should see my profile and be able to use the services.
  ```

- **US‑CUST‑002 — <View Providers and make appointment>**  
  _Story:_ As a customer, I want to see veternarian offices  so that I can make an appointment. 
  _Acceptance:_
  ```gherkin
  Scenario: Make and Appointment
    Given I locate an office I want to use
    When  I need to make an appointment
    Then  I can see the vet office's page and make an appointment.
  ```

### 2.2 Provider Stories
- **US‑PROV‑001 — <Account Managment>**  
  _Story:_ As a provider, i want to log in to my account to manage my appointments
  _Acceptance:**
  ```gherkin
  Scenario: Provier logs in 
    Given <i have a account >
    When  <when i enter a valid login>
    Then  <Then i should be logged in and see the provider dashboard>
  ```

- **US‑PROV‑002 — <View Request >**  
  _Story:_ As a provider, i want to view pending appointment request
  _Acceptance:**
  ```gherkin
  Scenario: <View pending appoointments>
    Given <i am logged in as a provider>
    When  <when i open the appointmnets page>
    Then  <then i should see a list of pending appointment requests>
  ```

### 2.3 SysAdmin Stories
- **US‑ADMIN‑001 — <Manage List Of Users>**  
  _Story:_ As a sysadmin, i want to view a list of all users so that i can manage accounts 
  _Acceptance:**
  ```gherkin
  Scenario: <view all users>
    Given <given i am logged in as a sysadmin >
    When  <when i open the user management page>
    Then  <then i should see a list of all user accounts>
  ```

- **US‑ADMIN‑002 — <Disable a User>**  
  _Story:_ As a sysadmin, I want to disable a user account so that i can handle problems 
  _Acceptance:_
  ```gherkin
  Scenario: <dissable a user 
    Given <given i am logged in as a sysadmin and a user exists>
    When  <when i disable the user account>
    Then  <the account should show as disabled in the user list>
  ```

---

## 3. Non‑Functional Requirements (make them measurable)
- **Performance:** 
- website should load within 5 seconds
- website should allow multiple users to use it at once
- location services should not take longer than 10 seconds
- website should display multiple offices

- **Availability/Reliability:** 
- should be running 100 percent of the time except for maintenace 
- maintenace will not be during the day and will  not take more than 4 hours
- backups for information will last at least 30 days

- **Security/Privacy:** 
- passwords and user profiles should be encrpyted
- system should log users and providers out after 30 minutes of inactivity
- lock the profile after 5 invalid attempts for a certain period of time
- profiles will not be shared and data will not be shared

- **Usability:** 
- should be easy to use and maintained, allowing users to make an appointment in less than 5 minutes
- compatiable on multiple devides (laptop, phones, etc)
- website should be easy to navigate, with clear descriptions of each page/ directory
- error messages should display if something is wrong 

---

## 4. Assumptions, Constraints, and Policies
**Assumptions**
- user has access to reliable internet
- user can access on multiple websites
- target audience has basic computer skills and abilities
- user can access accurate information
- provider will maintain availability and services

**Constraints**
- system must be devloped with HTML
- project must be completed by the end of the semester
- must be compatible at least on a desktop device
- scope is limited due to time and requirements document

**Policies**
- comply with data regulation laws
- user data must not be shared without consent 
- users must accept terms and conditions
- admin access must be authorized 
- content that is published must adhere to guidelines


---

## 5. Milestones (course‑aligned)
- **M2 Requirements** — this file + stories opened as issues. 
- **M3 High‑fidelity prototype** — core customer/provider flows fully interactive. 
- **M4 Design** — architecture, schema, API outline. 
- **M5 Backend API** — key endpoints + tests. 
- **M6 Increment** — ≥2 use cases end‑to‑end. 
- **M7 Final** — complete system & documentation. 

---

## 6. Change Management
- Stories are living artifacts; changes are tracked via repository issues and linked pull requests.  
- Major changes should update this SRS.
