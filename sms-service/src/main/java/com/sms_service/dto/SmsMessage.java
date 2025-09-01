package com.sms_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class SmsMessage {
    @NotBlank(message = "Sender cannot be blank")
    private String sender;

    @NotBlank(message = "Recipient cannot be blank")
    private String recipient;

    @NotBlank(message = "Message cannot be blank")
    @Size(max = 160, message = "Message cannot exceed 160 characters")
    private String message;

    private LocalDateTime timestamp;

    // Constructors
    public SmsMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public SmsMessage(String sender, String recipient, String message) {
        this.sender = sender;
        this.recipient = recipient;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }

    public String getRecipient() { return recipient; }
    public void setRecipient(String recipient) { this.recipient = recipient; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
