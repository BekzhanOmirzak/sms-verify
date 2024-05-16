package com.contact.smspush.model.request;

public record SMSValidateRequest(
        String user_id,
        String code
) {

}
