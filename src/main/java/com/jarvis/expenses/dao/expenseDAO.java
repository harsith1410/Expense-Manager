package com.jarvis.expenses.dao;

import com.jarvis.expenses.entity.Expense;

import java.util.List;

public interface expenseDAO {

    public List<Expense> getAllExpenses_ByUser(String user);

    public List<Expense> getAllExpenses_ByType(String Type);

    public Expense getExpenseById(int id);

    public void saveExpense(Expense expense);

    public void updateExpense(Expense expense);

    public void deleteExpense(int id);

//    public List<Expense> Show_All_Expenses();
//    public List<Expense> Show_Expense_byName(String expense_Name);
//    public List<Expense> Show_Expense_byType(String expense_type);
//    public Expense Show_Expense_byId(int expense_id);
//    public void AddExpense(Expense expense);
//    public Expense UpdateExpense(Expense expense);
//    public void DeleteExpense(int id);
    public int get_Expense_Amount();

    public int get_Income_Amount();

}
