package com.contact.smspush.controller;

import com.contact.smspush.config.TwillioConfig;
import com.contact.smspush.model.request.SMSSendRequest;
import com.contact.smspush.model.request.SMSValidateRequest;
import com.contact.smspush.service.iservice.ISMSSender;
import com.contact.smspush.service.iservice.ISMSService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class SMSController {

    private final ISMSService smsService;

    @PostMapping("/fire_sms_code")
    public ResponseEntity<Void> initSMSSend(@RequestBody SMSSendRequest smsSendRequest) {
        return smsService.initSMSSending(smsSendRequest);
    }

    @PostMapping("/validate_sms_code")
    public ResponseEntity<Void> validateSMSCode(@RequestBody SMSValidateRequest request) {
        return smsService.validSMSCode(request);
    }

}
