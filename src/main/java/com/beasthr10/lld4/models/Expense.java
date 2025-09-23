package com.beasthr10.lld4.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Entity
@Setter
public class Expense extends BaseModel{
    private  String discription;
    private  Double totalAmount;

    @ManyToOne
    private User createdBy;
    @Enumerated(EnumType.ORDINAL)
    private  ExpenseType expensetype;
    @ManyToOne
    private Group group;

    @OneToMany(mappedBy = "expense")
    private  List<ExpenseUser> expenseUsers;
}
