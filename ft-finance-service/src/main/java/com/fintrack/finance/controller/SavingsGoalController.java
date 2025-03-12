package com.fintrack.finance.controller;


import com.fintrack.finance.entity.SavingsGoal;
import com.fintrack.finance.service.SavingsGoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/savings-goals")
public class SavingsGoalController {

    @Autowired
    private SavingsGoalService savingsGoalService;

    @PostMapping
    public ResponseEntity<SavingsGoal> createSavingsGoal(@RequestBody SavingsGoal savingsGoal) {
        return ResponseEntity.ok(savingsGoalService.saveSavingsGoal(savingsGoal));
    }

    @GetMapping
    public ResponseEntity<List<SavingsGoal>> getSavingsGoals(@RequestParam Long userId) {
        return ResponseEntity.ok(savingsGoalService.getSavingsGoalsByUserId(userId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SavingsGoal> updateSavingsGoal(@PathVariable Long id, @RequestBody SavingsGoal savingsGoal) {
        return ResponseEntity.ok(savingsGoalService.updateSavingsGoal(id, savingsGoal));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSavingsGoal(@PathVariable Long id) {
        savingsGoalService.deleteSavingsGoal(id);
        return ResponseEntity.noContent().build();
    }
}