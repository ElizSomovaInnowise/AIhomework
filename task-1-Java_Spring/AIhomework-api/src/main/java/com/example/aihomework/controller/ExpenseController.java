package com.example.aihomework.controller;

import com.example.aihomework.model.Expense;
import com.example.aihomework.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("/calculate")
    public String calculateExpenses() {
        List<Expense> expenses = Arrays.asList(
                new Expense("Groceries", 15000),
                new Expense("Rent", 40000),
                new Expense("Transportation", 5000),
                new Expense("Entertainment", 10000),
                new Expense("Communication", 2000),
                new Expense("Gym", 3000)
        );

        double total = expenseService.calculateTotal(expenses);
        double average = expenseService.calculateAverage(expenses);
        List<Expense> top3 = expenseService.getTop3Expenses(expenses);

        StringBuilder result = new StringBuilder();
        result.append(String.format("Total Expenses: %.2f\n", total));
        result.append(String.format("Average Expense: %.2f\n", average));
        result.append("Top 3 Expenses:\n");
        for (Expense expense : top3) {
            result.append(String.format("  - %s: %.2f\n", expense.getCategory(), expense.getAmount()));
        }
        result.append("\n");

        return result.toString();
    }
} 