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

import java.security.Principal;
import java.util.List;

@Controller
public class expenseController {

    private expenseService service;

    @Autowired
    public expenseController(expenseService service) {
        this.service = service;
    }


    @GetMapping("/expenses")
    public String list_expenses(Principal principal, Model model) {

        List<Expense> list = service.getAllExpenses_ByUser(principal.getName());
        model.addAttribute("user",principal.getName());
        model.addAttribute("expenses", list);

        int expense_amt = service.get_Expense_Amount(principal.getName());
        model.addAttribute("e_amt", expense_amt);

        int income_amt = service.get_Income_Amount(principal.getName());
        model.addAttribute("income_amt", income_amt);

        int net_total =income_amt-expense_amt;
        model.addAttribute("net_total", net_total);

        return "home";
    }

    @GetMapping("/expenses/add")
    public String Add(@RequestParam("User") String User,Model theModel) {

        Expense theExpense = new Expense();

        theModel.addAttribute("expense", theExpense);
        theModel.addAttribute("user", User);

        return "expenseForm";
    }

    @GetMapping("/update")
    public String Update(@RequestParam("Id") int theId,@RequestParam("User") String User, Model theModel) {

        Expense theExpense = service.getExpenseById(theId);


        theModel.addAttribute("expense", theExpense);
        theModel.addAttribute("user", User);

        return "updateForm";
    }

    @PostMapping("/update/save")
    public String Updatesave(@ModelAttribute("expense") Expense theExpense,Principal principal) {
        theExpense.setExpenseUser(principal.getName());
        service.updateExpense(theExpense);
        return "redirect:/expenses";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("expense") Expense theExpense,Principal principal) {

        theExpense.setExpenseUser(principal.getName());

        service.saveExpense(theExpense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("Id") int theId) {

        service.deleteExpense(theId);

        return "redirect:/expenses";
    }

}
