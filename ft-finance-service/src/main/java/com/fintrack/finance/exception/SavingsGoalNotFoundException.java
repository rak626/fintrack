package com.fintrack.finance.exception;

public class SavingsGoalNotFoundException extends RuntimeException {
    public SavingsGoalNotFoundException(Long id) {
        super("Savings goal not found with id: " + id);
    }
}