package com.beasthr10.lld4.strategy;

import com.beasthr10.lld4.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("minMaxHeapSetteUpStrategy")
public class MinMaxHeapSetteUpStrategy implements iSettelUpStrategy{
    @Override
    public List<Expense> calculateTransaction(List<Expense> expensesForUser) {
        return List.of();
    }
}
