package com.beasthr10.lld4.strategy;

import com.beasthr10.lld4.models.Expense;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bruteForceSettleUpStrategy")
public class BruteForceSettleUpStrategy implements iSettelUpStrategy{
    @Override
    public List<Expense> calculateTransaction(List<Expense> expensesForUser) {
        return List.of();
    }
}
