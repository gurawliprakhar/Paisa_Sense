package com.example.aiparser.publisher;

import com.example.aiparser.model.ParsedExpense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ParsedExpensePublisher {

    @Autowired
    private KafkaTemplate<String, ParsedExpense> kafkaTemplate;

    public void publish(ParsedExpense expense) {
        kafkaTemplate.send("expenses-events", expense);
        System.out.println("Published parsed data: " + expense);
    }
}
