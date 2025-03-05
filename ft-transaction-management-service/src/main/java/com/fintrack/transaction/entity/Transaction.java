package com.fintrack.transaction.entity;

import com.fintrack.transaction.utils.TransactionUtils;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    @Enumerated(EnumType.STRING)
    private TransactionUtils.TransactionType transactionType; // income or expense
    private String category;
    private Double amount;
    private LocalDateTime date;
    private String description;

}
