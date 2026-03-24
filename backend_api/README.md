# sp26-02-team-3
# Spartan Vet Backend API

## Overview
This backend API was built for the Spartan Vet project using Spring Boot, Spring JPA, and PostgreSQL/Neon.

The API supports core backend features for the system
- Customers
- Vets
- Reviews
- Bookings
- Service Offerings

## Tech Stack
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL / Neon
- Maven
[uml.pdf](https://github.com/user-attachments/files/26215698/uml.pdf)


Main objects in the system
- User
- Customer
- Vet
- PetApplication
- Review
- Booking
- ServiceOffering

## API Endpoints

### Customers
- `POST /customers`  
  Create a new customer

- `GET /customers`  
  Get all customers

- `GET /customers/{id}`  
  Get a customer by id

- `PUT /customers/{id}`  
  Update a customer by id

- `DELETE /customers/{id}`  
  Delete a customer by id

### Vets
- `POST /vets`  
  Create a new vet

- `GET /vets`  
  Get all vets

- `GET /vets/{id}`  
  Get a vet by id

- `PUT /vets/{id}`  
  Update a vet by id

- `DELETE /vets/{id}`  
  Delete a vet by id

### Reviews
- `POST /reviews`  
  Create a new review

- `GET /reviews`  
  Get all reviews

- `GET /reviews/{id}`  
  Get a review by id

- `PUT /reviews/{id}`  
  Update a review by id

- `DELETE /reviews/{id}`  
  Delete a review by id

### Bookings
- `POST /bookings`  
  Create a new booking

- `GET /bookings`  
  Get all bookings

- `GET /bookings/{id}`  
  Get a booking by id

- `PUT /bookings/{id}`  
  Update a booking by id

- `DELETE /bookings/{id}`  
  Delete a booking by id

### Service Offerings
- `POST /services`  
  Create a new service offering

- `GET /services`  
  Get all service offerings

- `GET /services/{id}`  
  Get a service offering by id

- `PUT /services/{id}`  
  Update a service offering by id

- `DELETE /services/{id}`  
  Delete a service offering by id

## Use Case Mapping

### Customer Use Cases
- Create customer profile → `POST /customers`
- View all customers → `GET /customers`
- View customer by id → `GET /customers/{id}`
- Update customer profile → `PUT /customers/{id}`
- Delete customer profile → `DELETE /customers/{id}`

### Vet Use Cases
- Create vet profile → `POST /vets`
- View all vets → `GET /vets`
- View vet by id → `GET /vets/{id}`
- Update vet profile → `PUT /vets/{id}`
- Delete vet profile → `DELETE /vets/{id}`

### Review Use Cases
- Customer writes review → `POST /reviews`
- View all reviews → `GET /reviews`
- View review by id → `GET /reviews/{id}`
- Update review → `PUT /reviews/{id}`
- Delete review → `DELETE /reviews/{id}`

### Booking Use Cases
- Customer creates booking → `POST /bookings`
- View all bookings → `GET /bookings`
- View booking by id → `GET /bookings/{id}`
- Update booking → `PUT /bookings/{id}`
- Cancel/delete booking → `DELETE /bookings/{id}`

### Service Offering Use Cases
- Vet creates service offering → `POST /services`
- View all service offerings → `GET /services`
- View service offering by id → `GET /services/{id}`
- Update service offering → `PUT /services/{id}`
- Delete service offering → `DELETE /services/{id}`

## Example JSON Requests

Example JSON Requests
Customer
{
  "name": "Jowuan",
  "email": "jowuan@example.com"
}
Vet
{
  "name": "Dr Smith",
  "specialty": "Surgery"
}
Booking
{
  "petName": "Buddy",
  "serviceType": "Checkup",
  "appointmentDate": "2026-04-01"
}
Review
{
  "customerName": "Jowuan",
  "comment": "Great service",
  "rating": 5
}
Service
{
  "serviceName": "Vaccination",
  "price": 75.0
}
