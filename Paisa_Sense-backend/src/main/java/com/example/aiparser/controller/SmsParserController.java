package com.example.aiparser.controller;

import com.example.aiparser.model.SmsRequest;
import com.example.aiparser.model.ParsedResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class SmsParserController {

    @PostMapping("/parse-sms")
    public ResponseEntity<ParsedResult> parseSms(@RequestBody SmsRequest request) {
        String sms = request.getSms();
        if (sms == null) sms = "";  // Null check

        // Regex patterns
        Pattern amountPattern = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Pattern currencyPattern = Pattern.compile("(INR|USD|EUR)");
        Pattern datePattern = Pattern.compile("\\d{1,2}[a-z]{2}\\s\\w+\\s\\d{4}");
        Pattern accountPattern = Pattern.compile("ending\\s(\\d+)");

        Matcher amountMatcher = amountPattern.matcher(sms);
        Matcher currencyMatcher = currencyPattern.matcher(sms);
        Matcher dateMatcher = datePattern.matcher(sms);
        Matcher accountMatcher = accountPattern.matcher(sms);

        String amount = amountMatcher.find() ? amountMatcher.group(1) : "";
        String currency = currencyMatcher.find() ? currencyMatcher.group(1) : "";
        String date = dateMatcher.find() ? dateMatcher.group() : "";
        String account = accountMatcher.find() ? accountMatcher.group(1) : "";

        ParsedResult parsedResult = new ParsedResult(amount, currency, date, account);
        return ResponseEntity.ok(parsedResult);
    }
}
