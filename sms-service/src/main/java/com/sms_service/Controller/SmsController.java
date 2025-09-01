package com.sms_service.Controller;


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
        smsProducer.sendSms(smsMessage);
        return ResponseEntity.ok("SMS sent to Kafka successfully!");
    }
}
