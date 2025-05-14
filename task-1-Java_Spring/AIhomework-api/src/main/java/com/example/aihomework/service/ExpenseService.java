package com.example.aihomework.service;

import com.example.aihomework.model.Expense;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

    public double calculateTotal(List<Expense> expenses) {
        return expenses.stream().mapToDouble(Expense::getAmount).sum();
    }

    public double calculateAverage(List<Expense> expenses) {
        return calculateTotal(expenses) / 30;
    }

    public List<Expense> getTop3Expenses(List<Expense> expenses) {
        return expenses.stream()
                .sorted((e1, e2) -> Double.compare(e2.getAmount(), e1.getAmount()))
                .limit(3)
                .collect(Collectors.toList());
    }
} 