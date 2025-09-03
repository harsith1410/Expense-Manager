package com.jarvis.expenses.controller;

import com.jarvis.expenses.entity.Expense;
import com.jarvis.expenses.service.expenseService;
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

    public expenseController(expenseService service) {
        this.service = service;
    }

    @GetMapping("/expenses")
    public String list_expenses(Model model) {

        List<Expense> list = service.getAllExpenses();
        model.addAttribute("expenses", list);

        return "home";
    }

    @GetMapping("/add")
    public String Add(Model theModel) {

        Expense theExpense = new Expense();

        theModel.addAttribute("expense", theExpense);

        return "expenseForm";
    }

    @GetMapping("/update")
    public String Update(@RequestParam("id") int theId,
                                    Model theModel) {

        Expense theExpense = service.getExpenseById(theId);


        theModel.addAttribute("expense", theExpense);

        // send over to our form
        return "expenseForm";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("expense") Expense theExpense) {


        service.addExpense(theExpense);

        return "redirect:/expenses";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("expense") int theId) {

        service.deleteExpense(theId);

        return "redirect:/expenses";

    }

}
