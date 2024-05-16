package com.contact.smspush.service;

import com.contact.smspush.mapper.SMSMapper;
import com.contact.smspush.model.request.SMSSendRequest;
import com.contact.smspush.model.request.SMSValidateRequest;
import com.contact.smspush.repository.SMSRepository;
import com.contact.smspush.service.iservice.ISMSService;
import com.contact.smspush.service.iservice.ISMSSender;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SMSService implements ISMSService {

    private final SMSRepository smsRepository;
    private final ISMSSender smsSender;

    @Override
    public ResponseEntity<Void> initSMSSending(SMSSendRequest smsSendRequest) {
        var code = smsSender.sendSMS(smsSendRequest.phone_number());
        if (code == null)
            throw new RuntimeException("Code returned null");
        var smsSent = SMSMapper.smsSendRequestToEntity(smsSendRequest, code);
        smsRepository.save(smsSent);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> validSMSCode(SMSValidateRequest smsValidateRequest) {
        var smsSentOpt = smsRepository.findByUserId(smsValidateRequest.user_id());
        if (smsSentOpt.isEmpty()) {
            throw new RuntimeException("Not found sms validation entity by user id " + smsValidateRequest.user_id());
        }
        if (!Objects.equals(smsSentOpt.get().getCode(), smsValidateRequest.code())) {
            throw new RuntimeException("Validation sms code don't match with code ");
        }
        smsRepository.delete(smsSentOpt.get());
        return ResponseEntity.ok().build();
    }

}
