package com.lld.splitwise.commands;

import com.lld.splitwise.controllers.SettleUpController;
import com.lld.splitwise.dtos.SettleUpUserRequestDto;
import com.lld.splitwise.dtos.SettleUpUserResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpUserCommand implements Command {

    private final SettleUpController settleUpController;

    @Autowired
    public SettleUpUserCommand(SettleUpController settleUpController) {
        this.settleUpController = settleUpController;
    }

    @Override
    public void execute(String input) {
        List<String> words = List.of(input.split(" "));
        Long userId = Long.valueOf(words.get(0));

        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);

        SettleUpUserResponseDto responseDto = settleUpController.settleUpUser(requestDto);

    }

    @Override
    public boolean matches(String input) {

        List<String> words = List.of(input.split(" "));

        return words.size() == 2 &&
                words.get(1).equalsIgnoreCase(CommandKeyWords.SETTLE_UP);
    }
}
