package com.jarvis.expenses.dao;

import com.jarvis.expenses.entity.Expense;

import java.util.List;

public interface expenseDAO {

    public List<Expense> Show_All_Expenses();
    public List<Expense> Show_Expense_byName(String expense_Name);
    public List<Expense> Show_Expense_byType(String expense_type);
    public Expense Show_Expense_byId(int expense_id);
    public void AddExpense(Expense expense);
    public void UpdateExpense(int id,Expense expense);
    public void DeleteExpense(int id);

}
