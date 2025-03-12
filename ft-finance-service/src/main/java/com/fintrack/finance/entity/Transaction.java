package com.fintrack.finance.entity;

import com.fintrack.finance.utils.TransactionUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private TransactionUtils.TransactionType transactionType; // income or expense
    private String category;
    private Double amount;
    private LocalDateTime transactionDate;
    private String description;

}
