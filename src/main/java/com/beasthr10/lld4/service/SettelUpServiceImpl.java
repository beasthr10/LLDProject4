package com.beasthr10.lld4.service;

import com.beasthr10.lld4.exception.SettelUpException;
import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.models.ExpenseUser;
import com.beasthr10.lld4.models.User;
import com.beasthr10.lld4.repo.ExpenseUserRepository;
import com.beasthr10.lld4.repo.UserRepository;
import com.beasthr10.lld4.service.impl.ISetteleUpService;
import com.beasthr10.lld4.strategy.iSettelUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SettelUpServiceImpl implements ISetteleUpService {

    private final UserRepository userRepository;
    private final ExpenseUserRepository expenseUserRepository;
    private final iSettelUpStrategy SettelUpStrategy;


    @Autowired
    public SettelUpServiceImpl(UserRepository userRepository, ExpenseUserRepository expenseUserRepository, @Qualifier("minMaxHeapSetteUpStrategy") iSettelUpStrategy SettelUpStrategy) {
        this.userRepository = userRepository;
        this.expenseUserRepository = expenseUserRepository;
        this.SettelUpStrategy = SettelUpStrategy;
    }

    @Override
    public List<Expense> settelUp(Long userId) {
        /**
         * S1. fetch the user by userId. If user not found, throw exception.
         * S2. For the given user, get me all the List<Expense>
         * S3. Get the object by some factor
         * S4. Finally return the List<Transaction>
         */
        Optional<User> existingUser = userRepository.findById(userId);
        if(!existingUser.isPresent()){
            throw new SettelUpException("User not found for the given userId: " + userId);
        }

        User user = existingUser.get();
        List<ExpenseUser> expensesForUser = expenseUserRepository.findAllByUser(user);

        List<Expense> expenses = new ArrayList<>();
        for(ExpenseUser eu: expensesForUser){
            expenses.add(eu.getExpense());
        }


        List<Expense> transactionList = SettelUpStrategy.calculateTransaction(expenses);

        return transactionList;
    }
}
