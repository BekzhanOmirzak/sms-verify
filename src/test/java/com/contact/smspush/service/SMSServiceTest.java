package com.contact.smspush.service;


import com.contact.smspush.model.entities.SMSSent;
import com.contact.smspush.model.request.SMSSendRequest;
import com.contact.smspush.repository.SMSRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
public class SMSServiceTest {

    @Autowired
    private SMSService smsService;
    @MockBean
    private TwillioSMSSenderImpl smsSender;

    @MockBean
    private SMSRepository smsRepository;

    @Test
    public void sendingSMSSentSuccess() {
        var request = new SMSSendRequest("user_id_1", "+77763655665");
        var smsSent = SMSSent.builder()
                .phoneNumber(request.phone_number())
                .userId(request.user_id())
                .code("1234")
                .build();

        when(smsSender.sendSMS("+77763655665")).thenReturn("1234");
        when(smsRepository.save(smsSent)).thenReturn(smsSent);

        smsService.initSMSSending(request);

        verify(smsSender, times(1)).sendSMS(request.phone_number());
    }


}
