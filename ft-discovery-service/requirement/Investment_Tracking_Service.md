# Investment Tracking Service

## Business Scenario

### Scenario 4: Investment Tracking

#### Requirements:
- Users must be able to track investments in stocks, mutual funds, and other assets.
- The system should provide real-time updates on investment performance and market data.
- Integration with third-party financial APIs to fetch real-time market data.
- Users should be able to view their investment portfolio and performance metrics.

## Endpoints
- `POST /investments`: Add a new investment.
- `GET /investments`: Retrieve investment portfolio.
- `PUT /investments/{id}`: Update an existing investment.
- `DELETE /investments/{id}`: Remove an investment.
- `GET /investments/market-data`: Retrieve real-time market data.

## Database Schema
- Investment: `id`, `user_id`, `type`, `asset_name`, `quantity`, `purchase_price`, `current_value`, `purchase_date`, `created_at`, `updated_at`