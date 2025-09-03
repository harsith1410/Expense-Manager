package com.jarvis.expenses.dao;

import com.jarvis.expenses.entity.Expense;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class expenseDAO_Impl implements expenseDAO{

    private EntityManager em;

    @Autowired
    public expenseDAO_Impl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Expense> Show_All_Expenses() {
        TypedQuery<Expense> query = em.createQuery("Select e from Expense e", Expense.class);
        List<Expense> expenses = query.getResultList();
        return expenses;
    }

    @Override
    public List<Expense> Show_Expense_byName(String expense_Name) {

        TypedQuery<Expense> Query = em.createQuery(
                "select e from Expense e where e.expenseName = :expense_Name", Expense.class);
        Query.setParameter("expense_Name", expense_Name);
        List<Expense> expenses = Query.getResultList();

        return expenses;
    }

    @Override
    public List<Expense> Show_Expense_byType(String type) {

        TypedQuery<Expense> Query = em.createQuery(
                "select e from Expense e where e.expense_type = :type", Expense.class
        );
        Query.setParameter("type", type);
        List<Expense> expenses = Query.getResultList();

        return expenses;
    }

    @Override
    public Expense Show_Expense_byId(int expense_id) {

        Expense expense = em.find(Expense.class, expense_id);
        return expense;

    }

    @Override
    @Transactional
    public void AddExpense(Expense expense) {

        em.persist(expense);
        System.out.println("Expense added");

        return;
    }

    @Override
    @Transactional
    public void UpdateExpense(int id, Expense update_expense) {

        Expense expense = em.find(Expense.class, id);
        if(expense!=null) {
            expense.setExpenseName(update_expense.getExpenseName());
            expense.setExpense_type(update_expense.getExpense_type());
            expense.setAmount(update_expense.getAmount());
        }
        em.merge(expense);
        System.out.println("Expense updated");

    }

    @Override
    @Transactional
    public void DeleteExpense(int id) {
        Expense expense = em.find(Expense.class, id);
        em.remove(expense);
        System.out.println("Expense deleted");
    }
}
