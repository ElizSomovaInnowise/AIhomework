package com.example.aihomework.service;

import com.example.aihomework.model.Expense;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class ExpenseService {

    private final List<Expense> expenses = new ArrayList<>();

    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    public List<Expense> getAllExpenses() {
        return new ArrayList<>(expenses);
    }

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

    public void updateExpense(int id, Expense expense) {
        if (id >= 0 && id < expenses.size()) {
            expenses.set(id, expense);
        }
    }

    public void deleteExpense(int id) {
        if (id >= 0 && id < expenses.size()) {
            expenses.remove(id);
        }
    }
} 