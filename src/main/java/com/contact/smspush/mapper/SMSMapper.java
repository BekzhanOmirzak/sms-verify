package com.contact.smspush.mapper;

import com.contact.smspush.model.entities.SMSSent;
import com.contact.smspush.model.request.SMSSendRequest;

public class SMSMapper {

    public static SMSSent smsSendRequestToEntity(SMSSendRequest request, String code) {
        return SMSSent.builder()
                .userId(request.user_id())
                .phoneNumber(request.phone_number())
                .code(code)
                .build();
    }

}
