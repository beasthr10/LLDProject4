package com.beasthr10.lld4.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateExpenseRequestDTO {
    private String description;
    private List<Long> userIds;
    private double percentageSplit;
    private double totalAmount;
}
