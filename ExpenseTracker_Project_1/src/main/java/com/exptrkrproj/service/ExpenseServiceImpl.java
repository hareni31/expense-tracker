package com.exptrkrproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exptrkrproj.model.Expense;
import com.exptrkrproj.model.User;
import com.exptrkrproj.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
 @Autowired
 private ExpenseRepository expenseRepostiory;
	@Override
	public void save(Expense expense) {
		// TODO Auto-generated method stub
		expenseRepostiory.save(expense);
		
	}

	@Override
	public List<Expense> getExpensesByUser(User user) {
		// TODO Auto-generated method stub
		return expenseRepostiory.findByUser(user);
	}

}
