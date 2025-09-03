package com.jarvis.expenses.service;

import com.jarvis.expenses.dao.expenseDAO;
import com.jarvis.expenses.entity.Expense;

import java.util.List;

public interface expenseService {

    List<Expense> getAllExpenses();

    List<Expense> getExpensesByCategory(String category);

    List<Expense> getExpensesByType(String type);

    Expense getExpenseById(int id);

    void addExpense(Expense expense);

    void updateExpense(Expense expense);

    void deleteExpense(int id);

    int get_Expense_Amount();

    int get_Income_Amount();



}
