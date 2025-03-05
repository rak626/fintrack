# Notification Service

## Business Scenario

### Scenario 7: Real-Time Notifications

#### Requirements:
- The system should send real-time notifications for budget alerts, investment updates, and goal progress.
- Notifications should be delivered via email, SMS, and push notifications.
- Use Kafka for event-driven notifications to ensure timely delivery and processing.

## Endpoints
- `POST /notifications`: Send a notification.
- `GET /notifications`: Retrieve notifications history.
- `DELETE /notifications/{id}`: Delete a notification.

## Database Schema
- Notification: `id`, `user_id`, `type`, `message`, `status` (sent/pending), `created_at`, `updated_at`