# User Management Service

## Business Scenario

### Scenario 1: User Account Management

#### Requirements:
- Users must be able to register, authenticate, and manage their profiles.
- Authentication should be secure and based on JWT tokens.
- Users should be able to update their personal information and change passwords.

## Endpoints
- `POST /users/register`: Register a new user.
- `POST /users/login`: Authenticate a user and issue a JWT.
- `GET /users/profile`: Retrieve user profile information.
- `PUT /users/profile`: Update user profile information.

## Database Schema
- User: `id`, `username`, `password_hash`, `email`, `created_at`, `updated_at`
- Profile: `user_id`, `first_name`, `last_name`, `dob`, `address`

## Security
- Password hashing with bcrypt.
- JWT for authentication and authorization.