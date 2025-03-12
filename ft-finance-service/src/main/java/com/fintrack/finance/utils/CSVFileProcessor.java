package com.fintrack.finance.utils;


import com.fintrack.finance.entity.Transaction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CSVFileProcessor {

    public List<Transaction> parseCSV(InputStream inputStream) {
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Transaction transaction = new Transaction();
                transaction.setUserId(Long.parseLong(values[0]));
                transaction.setTransactionType(TransactionUtils.TransactionType.valueOf(values[1]));
                transaction.setCategory(values[2]);
                transaction.setAmount(Double.parseDouble(values[3]));
                transaction.setTransactionDate(LocalDateTime.parse(values[4]));
                transaction.setDescription(values[5]);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            log.error("Error while reading CSV file", e);
        }
        return transactions;
    }
}
