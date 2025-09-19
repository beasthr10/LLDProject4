package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class GroupExpense extends BaseModel{
    private final Group group;
    private final Expense expense;
}
