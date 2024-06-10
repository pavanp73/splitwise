package com.lld.splitwise.strategies;

import com.lld.splitwise.models.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeapSettleUpStrategy implements SettleUpStrategy {

    @Override
    public List<Expense> settleUp(List<Expense> expenses) {
        return List.of();
    }
}
