package com.example.aiparser.model;

public class SmsRequest {
    private String sms;

    // Default constructor (Spring needs it)
    public SmsRequest() {}

//    public SmsRequest(String sms) {
//        this.sms = sms;
//    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }
}
