package com.contact.smspush;

import com.contact.smspush.config.TwillioConfig;
import com.twilio.Twilio;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SmsPushApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmsPushApplication.class, args);
    }

}
