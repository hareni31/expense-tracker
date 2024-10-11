package com.exptrkrproj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exptrkrproj.model.Expense;
import com.exptrkrproj.model.User;

@Repository
public interface ExpenseRepository  extends JpaRepository<Expense, Long>{
	List<Expense>findByUser(User user);

}
