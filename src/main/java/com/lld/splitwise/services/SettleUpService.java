package com.lld.splitwise.services;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.User;
import com.lld.splitwise.models.UserExpense;
import com.lld.splitwise.repositories.UserExpenseRepository;
import com.lld.splitwise.repositories.UserRepository;
import com.lld.splitwise.strategies.SettleUpStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SettleUpService {

    private final UserRepository userRepository;
    private final UserExpenseRepository userExpenseRepository;
    private final SettleUpStrategy settleUpStrategy;

    @Autowired
    public SettleUpService(UserRepository userRepository,
                           UserExpenseRepository userExpenseRepository,
                           SettleUpStrategy settleUpStrategy) {
        this.userRepository = userRepository;
        this.userExpenseRepository = userExpenseRepository;
        this.settleUpStrategy = settleUpStrategy;
    }

    public List<Expense> settleUpUser(Long userId) {

        /*
        1. Get user with the given userId from DB
        2. Get all the expenses in which this user is involved
        3. Iterate through all the expenses and find out who has paid extra or less
            for every user involved in the above list of expenses
        4. User min heap and max heap to find out list of transactions required to
            settle up the user
         */

        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User is not found");
        }
        User user = optionalUser.get();
        List<UserExpense> userExpenses = userExpenseRepository.findByUser(user);

        Set<Expense> expenses = new HashSet<>();
        for (UserExpense userExpense : userExpenses) {
            expenses.add(userExpense.getExpense());
        }

        // heap algorithm to settle up list of expenses
        return settleUpStrategy.settleUp(expenses.stream().toList());
    }

    public List<Expense> settleUpGroup(Long groupId) {

        /*
        1. Get group with the given groupId from DB
        2. Get all the expenses within this group
        3. Iterate through all the expenses and find out who has paid extra or less
            for every user involved in the above list of expenses
        4. User min heap and max heap to find out list of transactions required to
            settle up the user
         */

        return null;
    }
}
