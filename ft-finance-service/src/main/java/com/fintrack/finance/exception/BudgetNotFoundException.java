package com.fintrack.finance.exception;


public class BudgetNotFoundException extends RuntimeException {
    public BudgetNotFoundException(Long id) {
        super("Budget not found with id: " + id);
    }
}
