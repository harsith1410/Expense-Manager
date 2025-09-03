package com.jarvis.expenses.service;


import com.jarvis.expenses.dao.expenseDAO;
import com.jarvis.expenses.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class expenseServiceImpl implements expenseService{

    private expenseDAO theExpenseDAO;

    public void setTheExpenseDAO(expenseDAO theExpenseDAO) {
        this.theExpenseDAO = theExpenseDAO;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return theExpenseDAO.Show_All_Expenses();
    }

    @Override
    public Expense getExpenseById(int id) {
        return theExpenseDAO.Show_Expense_byId(id);
    }

    @Override
    public List<Expense> getExpensesByCategory(String category) {
        return theExpenseDAO.Show_Expense_byName(category);
    }

    @Override
    public List<Expense> getExpensesByType(String type) {
        return theExpenseDAO.Show_Expense_byType(type);
    }

    @Override
    public void addExpense(Expense expense) {

        theExpenseDAO.AddExpense(expense);

    }

    @Override
    public Expense updateExpense(int id,Expense expense) {

        return theExpenseDAO.UpdateExpense(id, expense);
    }

    @Override
    public void deleteExpense(int id) {
        deleteExpense(id);
    }
}
