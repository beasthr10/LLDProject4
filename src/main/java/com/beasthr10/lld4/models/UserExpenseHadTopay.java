package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class UserExpenseHadTopay extends BaseModel{
    private final User user;
    private final Expense expense;
    private final double amount;
}
