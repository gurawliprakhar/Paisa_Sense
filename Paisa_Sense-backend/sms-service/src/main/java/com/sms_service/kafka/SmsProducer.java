package com.sms_service.kafka;


import com.sms_service.dto.SmsMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SmsProducer {
    private final KafkaTemplate<String, SmsMessage> kafkaTemplate;

    private static final String TOPIC = "sms-events";

    public SmsProducer(KafkaTemplate<String, SmsMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendSms(SmsMessage smsMessage) {
        kafkaTemplate.send(TOPIC, smsMessage);
        System.out.println("SMS sent to Kafka: " + smsMessage.getMessage());
    }
}
