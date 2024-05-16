package com.contact.smspush.repository;

import com.contact.smspush.model.entities.SMSSent;
import com.contact.smspush.repository.SMSRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DataJpaTest
class SMSRepositoryTest {

    @Autowired
    private SMSRepository smsRepository;

    @Test
    public void smsSentEntityShouldBeSaved() {

        var smsObject = SMSSent.builder()
                .code("1234")
                .phoneNumber("1234567890")
                .build();

        smsRepository.save(smsObject);

        var smsSent = smsRepository.findByPhoneNumber(smsObject.getPhoneNumber()).orElseThrow();

        assertEquals(smsObject.getCode(), smsSent.getCode());
        assertEquals(smsObject.getPhoneNumber(), smsSent.getPhoneNumber());
    }

    @Test
    public void smsSentEntityShouldBeDeleted() {
        var smsObject = SMSSent.builder()
               .code("1234")
               .phoneNumber("1234567890")
               .build();

        smsRepository.save(smsObject);

        var smsSent = smsRepository.findByPhoneNumber(smsObject.getPhoneNumber()).orElseThrow();

        assertEquals(smsObject.getCode(), smsSent.getCode());
        assertEquals(smsObject.getPhoneNumber(), smsSent.getPhoneNumber());

        smsRepository.delete(smsSent);

        assertThrows(RuntimeException.class, () -> smsRepository.findByPhoneNumber(smsObject.getPhoneNumber()).orElseThrow());
    }


}
