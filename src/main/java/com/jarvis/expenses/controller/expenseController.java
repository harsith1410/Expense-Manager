package com.jarvis.expenses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class expenseController {

    @GetMapping("/home")
    public String expenseController() {
        return "home";
    }

}
