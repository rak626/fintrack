package com.fintrack.finance.utils;

import com.fintrack.finance.entity.Budget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BudgetRecommendationEngine {

    public Budget recommendBudget(List<Budget> budgets) {
        // Implement recommendation logic based on historical spending patterns
        // For simplicity, this example returns a static recommendation
        Budget recommendedBudget = new Budget();
        recommendedBudget.setCategory("recommended");
        recommendedBudget.setAmount(500.0);
        return recommendedBudget;
    }
}
