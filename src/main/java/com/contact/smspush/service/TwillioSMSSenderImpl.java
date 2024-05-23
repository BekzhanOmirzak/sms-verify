package com.contact.smspush.service;

import com.contact.smspush.config.TwillioConfig;
import com.contact.smspush.service.iservice.ISMSSender;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TwillioSMSSenderImpl implements ISMSSender {

    private final TwillioConfig config;

    @Override
    public String sendSMS(String phoneNumber) {
        var smsCode = new Random().nextInt(10_000);
        Message.creator(
//                new PhoneNumber("whatsapp:" + phoneNumber),
//                new PhoneNumber("whatsapp:+14155238886"),
                new PhoneNumber(phoneNumber),
                new PhoneNumber(config.getFrom_number()),
                "Please, confirm you phone number, your sms-code is " + smsCode
        ).create();
        return smsCode + "";
    }


}
