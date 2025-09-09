package com.example.aiparser.model;

public class ParsedExpense {
    private double amount;
    private String currency;
    private String merchant;

    // Getters and Setters
    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getMerchant() { return merchant; }
    public void setMerchant(String merchant) { this.merchant = merchant; }

    @Override
    public String toString() {
        return "ParsedExpense{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                ", merchant='" + merchant + '\'' +
                '}';
    }
}
