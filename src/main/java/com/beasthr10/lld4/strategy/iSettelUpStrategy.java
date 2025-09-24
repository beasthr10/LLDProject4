package com.beasthr10.lld4.strategy;

import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.models.ExpenseUserType;

import java.util.List;

public interface iSettelUpStrategy {
    List<Expense> calculateTransaction(List<Expense> expensesForUser);
}
