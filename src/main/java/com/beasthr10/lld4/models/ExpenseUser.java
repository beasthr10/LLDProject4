package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class ExpenseUser extends BaseModel{
    @ManyToOne
    private  Expense expense;

    @ManyToOne
    private  User user;
    private  double amount;

    @Enumerated(EnumType.ORDINAL)
    private  ExpenseUserType expenseusertype;
}
