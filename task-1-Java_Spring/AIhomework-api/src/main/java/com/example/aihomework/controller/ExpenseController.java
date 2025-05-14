package com.example.aihomework.controller;

import com.example.aihomework.model.Expense;
import com.example.aihomework.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping("/add")
    public void addExpense(@RequestBody Expense expense) {
        expenseService.addExpense(expense);
    }

    @GetMapping("/list")
    public List<Expense> listExpenses() {
        return expenseService.getAllExpenses();
    }

    @PutMapping("/update/{id}")
    public void updateExpense(@PathVariable int id, @RequestBody Expense expense) {
        expenseService.updateExpense(id, expense);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpense(@PathVariable int id) {
        expenseService.deleteExpense(id);
    }

    @GetMapping("/calculate")
    public String calculateExpenses() {
        List<Expense> expenses = expenseService.getAllExpenses();

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