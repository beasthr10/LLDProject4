package com.beasthr10.lld4.strategy;

import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.models.ExpenseUser;
import com.beasthr10.lld4.models.ExpenseUserType;
import com.beasthr10.lld4.models.User;

import com.beasthr10.lld4.utility.Pair;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("minMaxHeapSetteUpStrategy")
public class MinMaxHeapSetteUpStrategy implements iSettelUpStrategy{
    @Override
    public List<Expense> calculateTransaction(List<Expense> expensesForUser) {
        Map<User,Double> userHadToPay = new HashMap<>();
        Map<User,Double> userPaid = new HashMap<>();

        for(Expense expense: expensesForUser){
            List<ExpenseUser> expenseUsers = expense.getExpenseUsers();
            for(ExpenseUser eu: expenseUsers){
                if(eu.getExpenseusertype().equals(ExpenseUserType.HAD_TO_PAY)){
                    Double existingAmount = userHadToPay.getOrDefault(eu.getUser(),0.0);
                    userHadToPay.put(eu.getUser(),existingAmount+eu.getAmount());
                }
                else if(eu.getExpenseusertype().equals(ExpenseUserType.PAID)){
                    Double existingAmount = userPaid.getOrDefault(eu.getUser(),0.0);
                    userPaid.put(eu.getUser(),existingAmount+eu.getAmount());
                }
            }
        }


        /**
         * S1. For every expense get list<ExpenseUser>, which will be all the user for that single expense from this lisr,
         * S2. Find List<Expense> where user had to pay the money
         */



        PriorityQueue<Pair<User, Double>> negativeBalanceQueue = new PriorityQueue<>((p1,p2)-> Double.compare(p1.getValue(),p2.getValue()));
        for(Map.Entry<User,Double> entry: userHadToPay.entrySet()){
            negativeBalanceQueue.add(new Pair(entry.getKey(),entry.getValue()));
        }
        PriorityQueue<Pair<User, Double>> positiveBalanceQueue = new PriorityQueue<>((p1,p2)-> Double.compare(p2.getValue(),p1.getValue()));
        for(Map.Entry<User,Double> entry: userPaid.entrySet()){
            negativeBalanceQueue.add(new Pair(entry.getKey(),entry.getValue()));
        }
        List<Expense> transactions = new ArrayList<>();
        while(!negativeBalanceQueue.isEmpty() || !positiveBalanceQueue.isEmpty()){
            Pair<User,Double> negativeMin = negativeBalanceQueue.poll();
            Pair<User,Double> positiveMax = positiveBalanceQueue.poll();


            if(negativeMin.getValue() < positiveMax.getValue()){
                transactions.add(new Expense(  )); // need to add later
                positiveBalanceQueue.add(positiveMax);
            }
            else{
                transactions.add(new Expense(  ));
                negativeBalanceQueue.add(negativeMin);
            }

        }


        return transactions;
    }
}
