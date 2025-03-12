package com.fintrack.finance.controller;


import com.fintrack.finance.entity.Investment;
import com.fintrack.finance.service.InvestmentService;
import com.fintrack.finance.utils.MarketDataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @Autowired
    private MarketDataFetcher marketDataFetcher;

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        return ResponseEntity.ok(investmentService.saveInvestment(investment));
    }

    @GetMapping
    public ResponseEntity<List<Investment>> getInvestments(@RequestParam Long userId) {
        return ResponseEntity.ok(investmentService.getInvestmentsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
        return ResponseEntity.ok(investmentService.updateInvestment(id, investment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/market-data")
    public ResponseEntity<String> getMarketData(@RequestParam String assetName) {
        String marketData = marketDataFetcher.fetchMarketData(assetName);
        return ResponseEntity.ok(marketData);
    }
}