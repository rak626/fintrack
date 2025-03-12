package com.fintrack.finance.controller;

import com.fintrack.finance.entity.Transaction;
import com.fintrack.finance.service.TransactionService;
import com.fintrack.finance.utils.CSVFileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/transactions/import")
public class ImportTransactionsController {

    @Autowired
    private CSVFileProcessor csvFileProcessor;

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<List<Transaction>> importTransactions(@RequestParam("file") MultipartFile file) {
        try {
            List<Transaction> transactions = csvFileProcessor.parseCSV(file.getInputStream());
            transactions.forEach(transactionService::saveTransaction);
            return ResponseEntity.ok(transactions);
        } catch (IOException e) {
            return ResponseEntity.status(500).build();
        }
    }
}
