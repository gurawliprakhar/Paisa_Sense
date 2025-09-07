package com.example.aiparser.service;

import com.example.aiparser.model.ParsedExpense;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class AiParserService {

    @Value("${ai.api.base-url}")
    private String baseUrl;

    @Value("${ai.api.token}")
    private String apiToken;

    private final RestTemplate restTemplate = new RestTemplate();

    public ParsedExpense parseSms(String smsText) {
        String url = baseUrl + "parse";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + apiToken);

        String requestBody = "{\"text\":\"" + smsText + "\"}";
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        try {
            ResponseEntity<ParsedExpense> response = restTemplate.exchange(
                    url, HttpMethod.POST, entity, ParsedExpense.class);

            return response.getBody();
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            System.out.println("API Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            // Optionally, return null or throw a custom exception
            return null;
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
            return null;
        }
    }
}
