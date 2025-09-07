package com.sms_service.kafka;

import com.sms_service.dto.SmsMessage;
import com.sms_service.entity.SmsLog;
import com.sms_service.repository.SmsLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SmsConsumer {

    private final SmsLogRepository smsLogRepository;

    public SmsConsumer(SmsLogRepository smsLogRepository) {
        this.smsLogRepository = smsLogRepository;
    }

    @KafkaListener(topics = "sms-events", groupId = "sms-group")
    public void consume(SmsLog smsMessage) {
        SmsLog log = new SmsLog();
        log.setSender(smsMessage.getSender());
        log.setRecipient(smsMessage.getRecipient());
        log.setMessage(smsMessage.getMessage());
        log.setTimestamp(smsMessage.getTimestamp());
        smsLogRepository.save(log);

        System.out.println("Consumed SMS and saved to DB: " + smsMessage.getMessage());
    }
}
