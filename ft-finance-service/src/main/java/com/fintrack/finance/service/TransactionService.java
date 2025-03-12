package com.fintrack.finance.service;


import com.fintrack.finance.entity.Transaction;
import com.fintrack.finance.exception.TransactionNotFoundException;
import com.fintrack.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByUserId(Long userId) {
        return transactionRepository.findByUserId(userId);
    }

    public List<Transaction> getTransactionsByUserIdAndDateRange(Long userId, LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findByUserIdAndTransactionDateBetween(userId, startDate, endDate);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {
        Transaction existingTransaction = transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException(id));
        existingTransaction.setTransactionType(transaction.getTransactionType());
        existingTransaction.setCategory(transaction.getCategory());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setTransactionDate(transaction.getTransactionDate());
        existingTransaction.setDescription(transaction.getDescription());
        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
