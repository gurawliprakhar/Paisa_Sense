package com.expense_service.web;

/**
 * DTO class for filtering expenses request.
 */
public class ExpenseFilterRequest {

    private String category;
    private Double minAmount;
    private Double maxAmount;

    // ===== Constructors =====
    public ExpenseFilterRequest() {
    }

    public ExpenseFilterRequest(String category, Double minAmount, Double maxAmount) {
        this.category = category;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
    }

    // ===== Getters & Setters =====
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Double minAmount) {
        this.minAmount = minAmount;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }
}
