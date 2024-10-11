package com.exptrkrproj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exptrkrproj.model.Expense;
import com.exptrkrproj.model.User;
import com.exptrkrproj.security.CustomerDetails;
import com.exptrkrproj.service.ExpenseService;

@Controller
public class DashboardController {
	
	@Autowired
	private ExpenseService expenseServie;
	@GetMapping("/dashboard")
	public String dashboard(@AuthenticationPrincipal CustomerDetails userDetails, Model model) {

	    User user = userDetails.getUser();
	    List<Expense> expenses = expenseServie.getExpensesByUser(user);

	    double foodTotal = expenses.stream()
	            .filter(e -> "Food".equals(e.getCategory()))
	            .mapToDouble(e -> e.getAmount().doubleValue())
	            .sum();

	    double travelTotal = expenses.stream()
	            .filter(e -> "Travel".equals(e.getCategory()))
	            .mapToDouble(e -> e.getAmount().doubleValue())
	            .sum();

	    double entertainmentTotal = expenses.stream()
	            .filter(e -> "Entertainment".equals(e.getCategory()))
	            .mapToDouble(e -> e.getAmount().doubleValue())
	            .sum();

	    double othersTotal = expenses.stream()
	            .filter(e -> "Others".equals(e.getCategory()))
	            .mapToDouble(e -> e.getAmount().doubleValue())
	            .sum();

	    double totalAmount = foodTotal + travelTotal + entertainmentTotal + othersTotal;

	    model.addAttribute("user", user);
	    model.addAttribute("expenses", expenses);
	    model.addAttribute("foodTotal", foodTotal);
	    model.addAttribute("travelTotal", travelTotal);
	    model.addAttribute("entertainmentTotal", entertainmentTotal);
	    model.addAttribute("othersTotal", othersTotal);
	    model.addAttribute("totalAmount", totalAmount);

	    return "dashboard";
	}
}
