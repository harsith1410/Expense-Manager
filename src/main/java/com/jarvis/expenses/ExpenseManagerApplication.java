package com.jarvis.expenses;

import com.jarvis.expenses.dao.expenseDAO;
import com.jarvis.expenses.entity.Expense;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(expenseDAO expenseDAO) {
		return runner ->{
			addExpense(expenseDAO);
		};
	}

	private void addExpense(expenseDAO expenseDAO) {
		Expense expense = new Expense("Food","Expense",250);
		expenseDAO.AddExpense(expense);
		System.out.println("Added expense");
	}
}
