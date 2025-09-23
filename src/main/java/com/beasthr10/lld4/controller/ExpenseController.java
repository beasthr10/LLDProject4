package com.beasthr10.lld4.controller;

import com.beasthr10.lld4.dto.CreateExpenseRequestDTO;
import com.beasthr10.lld4.dto.ExpenseResponseDTO;
import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.service.IExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {

    private final IExpenseService iexpenseService;

    @Autowired
    public ExpenseController(IExpenseService iexpenseService) {
        this.iexpenseService = iexpenseService;
    }

    @PostMapping("/expense")
    public ResponseEntity<ExpenseResponseDTO> createExpense(@RequestBody CreateExpenseRequestDTO dto){
       Expense createdExpense = iexpenseService.createExpense(dto.getDescription(), dto.getTotalAmount(), dto.getUserIds(), dto.getPercentageSplit());

       // Map createdExpense to ExpenseResponseDTO
        ExpenseResponseDTO response = new ExpenseResponseDTO();
        response.setDescription(createdExpense.getDiscription());
        response.setTotalAmount(createdExpense.getTotalAmount());

        return ResponseEntity.ok(response);
    }


}
