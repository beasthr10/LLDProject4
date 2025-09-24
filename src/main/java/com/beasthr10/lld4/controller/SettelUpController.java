package com.beasthr10.lld4.controller;

import com.beasthr10.lld4.dto.SettelUpResponseDTO;
import com.beasthr10.lld4.models.Expense;
import com.beasthr10.lld4.service.impl.ISetteleUpService;
import com.beasthr10.lld4.service.impl.ISetteleUpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettelUpController {

    private final ISetteleUpService iSetteleUpService;

    @Autowired
    public SettelUpController(ISetteleUpService iSetteleUpService) {
        this.iSetteleUpService = iSetteleUpService;
    }

    @PostMapping("/settleup/{userId}")
    public SettelUpResponseDTO settleUpForUser(@PathVariable("userId") Long userId) {
        List<Expense> transactionToExecute = iSetteleUpService.settelUp(userId);




        return null;
    }


}
