package com.expense_service.service;

import com.expense_service.entity.Expense;
import com.expense_service.repository.ExpenseRepository;
import com.expense_service.web.ExpenseFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for business logic related to expenses.
 */
@Service
public class ExpenseService {

    private final ExpenseRepository repo;

    @Autowired
    public ExpenseService(ExpenseRepository repo) {
        this.repo = repo;
    }

    /**
     * Save a new expense.
     */
    public Expense save(Expense expense) {
        return repo.save(expense);
    }

    /**
     * Get all expenses for a given userId.
     */
    public List<Expense> getByUser(Long userId) {
        return repo.findByUserId(userId);
    }

    /**
     * Get all expenses for a given category.
     */
    public List<Expense> getByCategory(String category) {
        return repo.findByCategory(category);
    }

    /**
     * Apply filters (category, min amount, max amount).
     */
    public List<Expense> filter(ExpenseFilterRequest req) {
        return repo.findAll().stream()
                .filter(e -> req.getCategory() == null || e.getCategory().equalsIgnoreCase(req.getCategory()))
                .filter(e -> req.getMinAmount() == null || e.getAmount() >= req.getMinAmount())
                .filter(e -> req.getMaxAmount() == null || e.getAmount() <= req.getMaxAmount())
                .collect(Collectors.toList());
    }
}
