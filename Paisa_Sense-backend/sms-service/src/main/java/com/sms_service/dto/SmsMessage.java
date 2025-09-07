package com.sms_service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;

public class SmsMessage {

    @NotBlank(message = "Sender cannot be blank")
    private String sender;

    @NotBlank(message = "Recipient cannot be blank")
    private String recipient;

    @NotBlank(message = "Message cannot be blank")
    @Size(max = 160, message = "Message cannot exceed 160 characters")
    private String message;

    @JsonIgnore  // Ignore this field in JSON mapping
    private LocalDateTime timestamp;

    @Autowired
    private KafkaTemplate<String, SmsMessage> kafkaTemplate;

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

    public void sendSms(SmsMessage smsMessage) {
        kafkaTemplate.send("sms-events", smsMessage);
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
