# Savings Goals Service

## Business Scenario

### Scenario 5: Savings Goals Management

#### Requirements:
- Users must be able to set and track savings goals (e.g., vacation, emergency fund).
- The system should provide progress updates and recommendations to help users achieve their savings goals.
- Integration with the budgeting service to allocate funds automatically towards savings goals.
- Users should receive notifications about their savings progress and any necessary adjustments.

## Endpoints
- `POST /savings-goals`: Set a new savings goal.
- `GET /savings-goals`: Retrieve savings goals and progress.
- `PUT /savings-goals/{id}`: Update an existing savings goal.
- `DELETE /savings-goals/{id}`: Delete a savings goal.

## Database Schema
- SavingsGoal: `id`, `user_id`, `goal_name`, `target_amount`, `current_amount`, `deadline`, `created_at`, `updated_at`