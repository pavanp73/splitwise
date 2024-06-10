package com.lld.splitwise.repositories;

import com.lld.splitwise.models.User;
import com.lld.splitwise.models.UserExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserExpenseRepository extends JpaRepository<UserExpense, Long> {

    List<UserExpense> findByUser(User user);
}
