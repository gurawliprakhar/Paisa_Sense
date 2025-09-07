package com.example.aiparser.model;

public class ParsedResult {
    private String amount;
    private String currency;
    private String date;
    private String account;

    public ParsedResult() {}  // Default constructor

    public ParsedResult(String amount, String currency, String date, String account) {
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.account = account;
    }

    // Getters & Setters
    public String getAmount() { return amount; }
    public void setAmount(String amount) { this.amount = amount; }

    public String getCurrency() { return currency; }
    public void setCurrency(String currency) { this.currency = currency; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }
}
