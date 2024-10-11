package com.exptrkrproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.exptrkrproj.model.Expense;
import com.exptrkrproj.model.User;
import com.exptrkrproj.security.CustomerDetails;
import com.exptrkrproj.service.ExpenseService;

@Controller
public class ExpenseController {
	@Autowired
	private ExpenseService expenseService;
	//show the form to add new expense
	@GetMapping("/addExpense")
	public String showAddExpenseForm() {
		return "addExpense";
		
	}
	@PostMapping("/addExpense")
	public String addExpense(Expense expense,@AuthenticationPrincipal CustomerDetails useDetails)
	{
		User user=useDetails.getUser();
		expense.setUser(user);//set the user for the expense
		expenseService.save(expense);//save the expenses
		return "redirect:/dashboard";
		
	}
	

}
