package com.expense_service.consumer;

import com.expense_service.entity.Expense;
import com.expense_service.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Kafka Consumer for listening to expense events and saving them into DB.
 */
@Service
public class ExpenseConsumer {

    private final ExpenseRepository repo;

    @Autowired
    public ExpenseConsumer(ExpenseRepository repo) {
        this.repo = repo;
    }

    @KafkaListener(topics = "expenses-events", groupId = "expense-service-group")
    public void consume(String message) {
        try {
            // Example message format: "101,pizza order,450.0"
            String[] parts = message.split(",");

            Long userId = Long.parseLong(parts[0]);
            String description = parts[1];
            Double amount = Double.parseDouble(parts[2]);

            Expense expense = new Expense();
            expense.setUserId(userId);
            expense.setDescription(description);
            expense.setAmount(amount);
            expense.setCategory(categorize(description));
            expense.setCreatedAt(LocalDateTime.now());

            repo.save(expense);

            System.out.println(" Expense saved: " + expense);

        } catch (Exception e) {
            System.err.println(" Error while consuming expense event: " + e.getMessage());
        }
    }

    /**
     * Simple categorization logic based on description keywords.
     */
    private String categorize(String desc) {
        String lower = desc.toLowerCase();

        if (lower.contains("food") || lower.contains("pizza")) return "Food";
        if (lower.contains("uber") || lower.contains("bus") || lower.contains("train")) return "Travel";
        if (lower.contains("amazon") || lower.contains("shopping") || lower.contains("mall")) return "Shopping";

        return "Others";
    }
}
