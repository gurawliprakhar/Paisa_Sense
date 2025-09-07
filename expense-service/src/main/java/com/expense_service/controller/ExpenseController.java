package com.expense_service.controller;

import com.expense_service.entity.Expense;
import com.expense_service.service.ExpenseService;
import com.expense_service.web.ExpenseFilterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for exposing Expense APIs.
 */
@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    private final ExpenseService service;

    @Autowired
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    /**
     * Create a new expense.
     * Example: POST /expenses
     * Body: {"userId":1, "category":"Food", "amount":250.0, "description":"Pizza order"}
     */
    @PostMapping
    public Expense createExpense(@RequestBody Expense expense) {
        return service.save(expense); // make sure ExpenseService has save() implemented
    }

    /**
     * Get all expenses of a specific user.
     * Example: GET /expenses/user/101
     */
    @GetMapping("/user/{id}")
    public List<Expense> getByUser(@PathVariable Long id) {
        return service.getByUser(id);
    }

    /**
     * Get all expenses of a specific category.
     * Example: GET /expenses/category/Food
     */
    @GetMapping("/category/{type}")
    public List<Expense> getByCategory(@PathVariable String type) {
        return service.getByCategory(type);
    }

    /**
     * Filter expenses by category and amount range.
     * Example: POST /expenses/filter
     * Body: {"category":"Food", "minAmount":100, "maxAmount":500}
     */
    @PostMapping("/filter")
    public List<Expense> filter(@RequestBody ExpenseFilterRequest req) {
        return service.filter(req);
    }
}
