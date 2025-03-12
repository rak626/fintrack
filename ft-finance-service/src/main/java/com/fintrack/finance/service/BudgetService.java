package com.fintrack.finance.service;

import com.fintrack.finance.entity.Budget;
import com.fintrack.finance.exception.BudgetNotFoundException;
import com.fintrack.finance.repository.BudgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    public Budget saveBudget(Budget budget) {
        budget.setCreatedAt(LocalDateTime.now());
        budget.setUpdatedAt(LocalDateTime.now());
        return budgetRepository.save(budget);
    }

    public List<Budget> getBudgetsByUserId(Long userId) {
        return budgetRepository.findByUserId(userId);
    }

    public List<Budget> getBudgetsByUserIdAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return budgetRepository.findByUserIdAndStartDateBetween(userId, startDate, endDate);
    }

    public Budget updateBudget(Long id, Budget budget) {
        Budget existingBudget = budgetRepository.findById(id).orElseThrow(() -> new BudgetNotFoundException(id));
        existingBudget.setCategory(budget.getCategory());
        existingBudget.setAmount(budget.getAmount());
        existingBudget.setStartDate(budget.getStartDate());
        existingBudget.setEndDate(budget.getEndDate());
        existingBudget.setUpdatedAt(LocalDateTime.now());
        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long id) {
        budgetRepository.deleteById(id);
    }
}
