package com.jarvis.expenses.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_no")
    private int expenseId;

    @Column(name = "expense_name")
    private String expenseName;

    @Column(name = "expense_type")
    private String expense_type;

    @Column(name = "expense_price")
    private String amount;

    public Expense() {}

    public Expense(String expenseName, String expense_type, String amount) {
        this.expenseName = expenseName;
        this.expense_type = expense_type;
        this.amount = amount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpense_type() {
        return expense_type;
    }

    public void setExpense_type(String expense_type) {
        this.expense_type = expense_type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
