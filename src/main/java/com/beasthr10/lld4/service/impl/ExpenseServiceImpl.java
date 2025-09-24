package com.beasthr10.lld4.service.impl;

import com.beasthr10.lld4.exception.ExpenseCreationException;
import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.models.ExpenseType;
import com.beasthr10.lld4.models.ExpenseUser;
import com.beasthr10.lld4.models.User;
import com.beasthr10.lld4.repo.ExpenseRepo;
import com.beasthr10.lld4.repo.UserRepository;
import com.beasthr10.lld4.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements IExpenseService {
    private final ExpenseRepo expenseRepo;
    private final UserRepository userRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepo expenseRepo, UserRepository userRepository) {
        this.expenseRepo = expenseRepo;
        this.userRepository = userRepository;
    }


    @Override
    public Expense createExpense(String description, double totalAmount, List<Long> userIds, String splitType) throws ExpenseCreationException {
        Expense newExpense = new Expense();
        List<ExpenseUser> expenseUsers = new ArrayList<>();
        for(Long userId : userIds){
            Optional<User> user = userRepository.findById(userId);
            if(!user.isPresent()){
                throw new ExpenseCreationException("Error in creating expense");
            }
            ExpenseUser expenseUser = new ExpenseUser();
            expenseUser.setAmount(calculateAmountForUser(totalAmount,splitType,userIds.size())); // Set appropriate amount based on your logic
            expenseUser.setExpenseusertype(null);
            expenseUser.setUser(user.get());


            expenseUsers.add(expenseUser);
        }

        newExpense.setExpenseUsers(expenseUsers);
        newExpense.setCreatedAt(new Date());
        newExpense.setLastModifiedAt(new Date());
        newExpense.setExpensetype(ExpenseType.NORMAL);
        newExpense.setDiscription(description);
        newExpense.setTotalAmount(totalAmount);

       Expense expense = expenseRepo.save(newExpense);
       return expense;
    }

    private double calculateAmountForUser(double totalAmount, String splitType, int totalUsersSize) {
        double amountForUser =0;
        if(splitType.equals("EQUAL")){
            amountForUser = totalAmount/totalUsersSize;
        }


        return amountForUser;
    }
}
