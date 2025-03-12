package com.fintrack.finance.service;


import com.fintrack.finance.entity.Investment;
import com.fintrack.finance.exception.InvestmentNotFoundException;
import com.fintrack.finance.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    public Investment saveInvestment(Investment investment) {
        investment.setCreatedAt(LocalDateTime.now());
        investment.setUpdatedAt(LocalDateTime.now());
        return investmentRepository.save(investment);
    }

    public List<Investment> getInvestmentsByUserId(Long userId) {
        return investmentRepository.findByUserId(userId);
    }

    public Investment updateInvestment(Long id, Investment investment) {
        Investment existingInvestment = investmentRepository.findById(id).orElseThrow(() -> new InvestmentNotFoundException(id));
        existingInvestment.setType(investment.getType());
        existingInvestment.setAssetName(investment.getAssetName());
        existingInvestment.setQuantity(investment.getQuantity());
        existingInvestment.setPurchasePrice(investment.getPurchasePrice());
        existingInvestment.setCurrentValue(investment.getCurrentValue());
        existingInvestment.setPurchaseDate(investment.getPurchaseDate());
        existingInvestment.setUpdatedAt(LocalDateTime.now());
        return investmentRepository.save(existingInvestment);
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}