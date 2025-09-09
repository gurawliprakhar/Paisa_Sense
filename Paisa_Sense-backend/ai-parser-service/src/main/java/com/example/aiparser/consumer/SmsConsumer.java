package com.example.aiparser.consumer;


import com.example.aiparser.model.ParsedExpense;
import com.example.aiparser.publisher.ParsedExpensePublisher;
import com.example.aiparser.service.AiParserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SmsConsumer {
    @Autowired
    private AiParserService aiParserService;

    @Autowired
    private ParsedExpensePublisher parsedExpensePublisher;

    @KafkaListener(topics = "sms-events", groupId = "ai-parser-group")
    public void consume(String smsJson) throws Exception {
        System.out.println("Received SMS: " + smsJson);

        // Parse SMS using AI
        ParsedExpense expense = aiParserService.parseSms(smsJson);

        // Publish parsed data
        parsedExpensePublisher.publish(expense);
    }
}
