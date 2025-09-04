package com.jarvis.expenses.service;

import com.jarvis.expenses.dao.expenseDAO;
import com.jarvis.expenses.entity.Expense;

import java.util.List;

public interface expenseService {

    public List<Expense> getAllExpenses_ByUser(String user);

    public List<Expense> getAllExpenses_ByType(String Type);

    public Expense getExpenseById(int id);

    public void saveExpense(Expense expense);

    public void updateExpense(Expense expense);

    public void deleteExpense(int id);

    public int get_Expense_Amount();

    public int get_Income_Amount();



//    List<Expense> getAllExpenses();
//
//    List<Expense> getExpensesByCategory(String category);
//
//    List<Expense> getExpensesByType(String type);
//
//    Expense getExpenseById(int id);
//
//    void addExpense(Expense expense);
//
//    void updateExpense(Expense expense);
//
//    void deleteExpense(int id);
//
//    int get_Expense_Amount();
//
//    int get_Income_Amount();



}
