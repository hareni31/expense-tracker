package com.exptrkrproj.service;

import java.util.List;

import com.exptrkrproj.model.Expense;
import com.exptrkrproj.model.User;

public interface ExpenseService {
	void save(Expense expense);
	List<Expense>getExpensesByUser(User user);

}
