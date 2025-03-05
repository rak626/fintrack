# Transaction Management Service

## Business Scenario

### Scenario 2: Income and Expense Tracking

#### Requirements:
- Users must be able to record and categorize income and expenses.
- Support for recurring transactions (e.g., monthly rent, salary).
- Users should be able to import transactions from bank statements in CSV and OFX formats.
- The system should automatically categorize transactions based on predefined rules.

## Endpoints
- `POST /transactions`: Record a new transaction.
- `GET /transactions`: Retrieve transactions with filtering options.
- `PUT /transactions/{id}`: Update an existing transaction.
- `DELETE /transactions/{id}`: Delete a transaction.
- `POST /transactions/import`: Import transactions from a file.

## Database Schema
- Transaction: `id`, `user_id`, `type` (income/expense), `category`, `amount`, `date`, `description`, `created_at`, `updated_at`