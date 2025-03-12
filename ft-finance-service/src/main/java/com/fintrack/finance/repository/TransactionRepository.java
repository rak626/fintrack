package com.fintrack.finance.repository;

import com.fintrack.finance.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByUserId(Long userId);

    List<Transaction> findByUserIdAndTransactionDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}
