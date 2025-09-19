package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Entity
public class Expense extends BaseModel{
    private final String discription;
    private final Double amount;
    private final CurrencyType currencytype;
    private final List<User> participants;
    private final User createdByUserId;


}
