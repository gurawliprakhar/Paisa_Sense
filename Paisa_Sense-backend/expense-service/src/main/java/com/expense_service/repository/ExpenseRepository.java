package com.expense_service.repository;

import com.expense_service.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Expense entity.
 */
@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Find expenses by userId
    List<Expense> findByUserId(Long userId);

    // Find expenses by category
    List<Expense> findByCategory(String category);
}
