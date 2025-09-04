package com.jarvis.expenses.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expense_id")
    private int id;

    @Column(name = "expense_user")
    private String expenseUser;

    @Column(name = "expense_date")
    private String expenseDate;

    @Column(name = "expense_category")
    private String expenseCategory;

    @Column(name = "expense_details")
    private String expenseDetails;

    @Column(name = "expense_type")
    private String expense_type;

    @Column(name = "expense_price")
    private int amount;

    public Expense() {}

    public Expense(String expenseUser, String expenseDate, String expenseCategory, String expenseName, String expense_type, int amount) {
        this.expenseUser = expenseUser.toUpperCase();
        this.expenseDate = expenseDate.toUpperCase();
        this.expenseCategory = expenseCategory.toUpperCase();
        this.expenseDetails = expenseName.toUpperCase();
        this.expense_type = expense_type.toUpperCase();
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpenseUser() {
        return expenseUser;
    }

    public void setExpenseUser(String expenseUser) {
        this.expenseUser = expenseUser.toUpperCase();
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate.toUpperCase();
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory.toUpperCase();
    }

    public String getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(String expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    public String getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(String expense_type) {
        this.expense_type = expense_type.toUpperCase();
    }

    public int getAmount() {
        return Math.abs(amount);
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
