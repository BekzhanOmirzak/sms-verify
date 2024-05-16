package com.contact.smspush.service.iservice;

import com.contact.smspush.model.request.SMSSendRequest;
import com.contact.smspush.model.request.SMSValidateRequest;
import org.springframework.http.ResponseEntity;

public interface ISMSService {

    ResponseEntity<Void> initSMSSending(SMSSendRequest smsSendRequest);

    ResponseEntity<Void> validSMSCode(SMSValidateRequest smsValidateRequest);

}
