package com.contact.smspush.model.request;

public record SMSSendRequest(
        String user_id,
        String phone_number
) {

}
