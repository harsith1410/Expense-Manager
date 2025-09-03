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
        return query.getResultList();
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

        if (expense.getExpense_type().equals("Expense")) {
            expense.setAmount(expense.getAmount()*-1);
        }

        em.persist(expense);
        System.out.println("Expense added");

        return;
    }

    @Override
    @Transactional
    public Expense UpdateExpense(Expense update_expense) {

        if (update_expense.getExpense_type().equals("Expense")) {
            update_expense.setAmount(Math.abs(update_expense.getAmount())*-1);
        }
        else{
            update_expense.setAmount(Math.abs(update_expense.getAmount()));
        }

        em.merge(update_expense);
        System.out.println("Expense updated");
        return update_expense;

    }

    @Override
    @Transactional
    public void DeleteExpense(int id) {
        Expense expense = em.find(Expense.class, id);
        em.remove(expense);
        System.out.println("Expense deleted");
    }

    @Override
    public int get_Expense_Amount() {
        List<Expense> expenses = Show_Expense_byType("EXPENSE");
        int amt = 0;
        for (Expense expense : expenses) {
            amt += expense.getAmount();
        }
        return amt;
    }

    @Override
    public int get_Income_Amount() {
        List<Expense> expenses = Show_Expense_byType("INCOME");
        int amt = 0;
        for (Expense expense : expenses) {
            amt += expense.getAmount();
        }
        return amt;
    }


}
