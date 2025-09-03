package com.jarvis.expenses.controller;

import com.jarvis.expenses.entity.Expense;
import com.jarvis.expenses.service.expenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class expenseController {

    private expenseService service;

    @Autowired
    public expenseController(expenseService service) {
        this.service = service;
    }

    @GetMapping("/expenses")
    public String list_expenses(Model model) {

        List<Expense> list = service.getAllExpenses();
        model.addAttribute("expenses", list);

        int expense_amt = service.get_Expense_Amount();
        model.addAttribute("e_amt", expense_amt);

        int income_amt = service.get_Income_Amount();
        model.addAttribute("income_amt", income_amt);

        int net_total =income_amt-expense_amt;
        model.addAttribute("net_total", net_total);

        return "home";
    }

    @GetMapping("/expenses/add")
    public String Add(Model theModel) {

        Expense theExpense = new Expense();

        theModel.addAttribute("expense", theExpense);

        return "expenseForm";
    }

    @GetMapping("/update")
    public String Update(@RequestParam("expenseId") int theId, Model theModel) {

        Expense theExpense = service.getExpenseById(theId);


        theModel.addAttribute("expense", theExpense);

        // send over to our form
        return "updateForm";
    }

    @PostMapping("/update/save")
    public String Updatesave(@ModelAttribute("expense") Expense theExpense) {
        service.updateExpense(theExpense);
        return "redirect:/expenses";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("expense") Expense theExpense) {


        service.addExpense(theExpense);

        return "redirect:/expenses";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("expenseId") int theId) {

        service.deleteExpense(theId);

        return "redirect:/expenses";
    }

}
