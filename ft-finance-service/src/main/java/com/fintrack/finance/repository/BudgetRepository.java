package com.fintrack.finance.repository;


import com.fintrack.finance.entity.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {
    List<Budget> findByUserId(Long userId);

    List<Budget> findByUserIdAndStartDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);
}
