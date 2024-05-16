package com.contact.smspush.config;

import com.twilio.Twilio;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TwillioConfig {

    @Value("${twillio.account-sid}")
    private String account_sid;
    @Value("${twillio.auth-token}")
    private String auth_token;
    @Value("${twillio.from-number}")
    private String from_number;

    @PostConstruct
    public void init() {
        System.out.println("Account SID  , Auth Token " + account_sid + " " + auth_token);
        Twilio.init(account_sid, auth_token);
    }



}
