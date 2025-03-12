package com.fintrack.finance.service;


import com.fintrack.finance.entity.SavingsGoal;
import com.fintrack.finance.exception.SavingsGoalNotFoundException;
import com.fintrack.finance.repository.SavingsGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SavingsGoalService {

    @Autowired
    private SavingsGoalRepository savingsGoalRepository;

    public SavingsGoal saveSavingsGoal(SavingsGoal savingsGoal) {
        savingsGoal.setCreatedAt(LocalDateTime.now());
        savingsGoal.setUpdatedAt(LocalDateTime.now());
        return savingsGoalRepository.save(savingsGoal);
    }

    public List<SavingsGoal> getSavingsGoalsByUserId(Long userId) {
        return savingsGoalRepository.findByUserId(userId);
    }

    public SavingsGoal updateSavingsGoal(Long id, SavingsGoal savingsGoal) {
        SavingsGoal existingSavingsGoal = savingsGoalRepository.findById(id).orElseThrow(() -> new SavingsGoalNotFoundException(id));
        existingSavingsGoal.setGoalName(savingsGoal.getGoalName());
        existingSavingsGoal.setTargetAmount(savingsGoal.getTargetAmount());
        existingSavingsGoal.setSavedAmount(savingsGoal.getSavedAmount());
        existingSavingsGoal.setTargetDate(savingsGoal.getTargetDate());
        existingSavingsGoal.setUpdatedAt(LocalDateTime.now());
        return savingsGoalRepository.save(existingSavingsGoal);
    }

    public void deleteSavingsGoal(Long id) {
        savingsGoalRepository.deleteById(id);
    }
}