package com.sms_service.controller;


import com.sms_service.dto.SmsMessage;
import com.sms_service.kafka.SmsProducer;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sms")
public class SmsController {

    private final SmsProducer smsProducer;

    public SmsController(SmsProducer smsProducer) {
        this.smsProducer = smsProducer;
    }

    @PostMapping("/new")
    public ResponseEntity<String> sendSms(@Valid @RequestBody SmsMessage smsMessage) {
        try {
            smsProducer.sendSms(smsMessage);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Kafka error: " + e.getMessage());
        }
        return ResponseEntity.ok("SMS sent to Kafka successfully!");
    }
}
