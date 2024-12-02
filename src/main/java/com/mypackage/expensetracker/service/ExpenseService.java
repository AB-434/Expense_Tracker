package com.mypackage.expensetracker.service;

import com.mypackage.expensetracker.model.Expense;
import com.mypackage.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense updateExpense(Long id, Expense expense) {
        Optional<Expense> existingExpense = expenseRepository.findById(id);
        if(existingExpense.isPresent()) {
            expense.setId(id);
            return expenseRepository.save(expense);
        }
        throw new RuntimeException("Expense not found with ID: " + id);
    }

    public List<Expense> getExpenseByCategory(String category) {
        return expenseRepository.findByCategory(category);
    }

}
