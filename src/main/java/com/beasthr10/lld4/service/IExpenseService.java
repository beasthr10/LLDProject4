package com.beasthr10.lld4.service;

import com.beasthr10.lld4.exception.ExpenseCreationException;
import com.beasthr10.lld4.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IExpenseService {
    Expense createExpense(String description, double totalAmount, List<Long> userIds, String splitType) throws ExpenseCreationException;
}
