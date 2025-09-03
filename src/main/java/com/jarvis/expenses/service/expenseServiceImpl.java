package com.jarvis.expenses.service;


import com.jarvis.expenses.dao.expenseDAO;
import com.jarvis.expenses.entity.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class expenseServiceImpl implements expenseService{

    private expenseDAO theExpenseDAO;

    @Autowired
    public void setTheExpenseDAO(expenseDAO theExpenseDAO) { //
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
    public void updateExpense(Expense expense) {

        Expense expense1 = theExpenseDAO.UpdateExpense(expense);
        System.out.println("Expense updated" + expense1);
    }

    @Override
    public void deleteExpense(int id) {
        theExpenseDAO.DeleteExpense(id);
    }

    @Override
    public int get_Expense_Amount() {
        return theExpenseDAO.get_Expense_Amount();
    }

    @Override
    public int get_Income_Amount() {
        return theExpenseDAO.get_Income_Amount();
    }


}
