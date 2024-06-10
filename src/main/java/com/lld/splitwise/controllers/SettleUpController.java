package com.lld.splitwise.controllers;

import com.lld.splitwise.dtos.SettleUpGroupRequestDto;
import com.lld.splitwise.dtos.SettleUpUserRequestDto;
import com.lld.splitwise.dtos.SettleUpUserResponseDto;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.services.SettleUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class SettleUpController {

    private final SettleUpService settleUpService;

    @Autowired
    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    // methods related to settle up

    /*
    settle up should return list of transactions
    which when executed will make the net amount
    of a user to be 0
     */

    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto requestDto) {

        List<Expense> expenses = settleUpService.settleUpUser(
                requestDto.getUserId()
        );
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();
        responseDto.setExpenses(expenses);
        return responseDto;

    }

    public SettleUpUserResponseDto settleUpGroup(SettleUpGroupRequestDto requestDto) {
        return null;
    }
}
