package com.contact.smspush.controller;


import com.contact.smspush.model.request.SMSSendRequest;
import com.contact.smspush.model.request.SMSValidateRequest;
import com.contact.smspush.service.SMSService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SMSController.class)
public class SMSControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SMSService service;

    @Test
    public void checking_fire_sms_code() throws Exception {
        var request = new SMSSendRequest("user_id_1", "+77763655665");
        when(service.initSMSSending(request)).thenReturn(ResponseEntity.ok().build());

        mockMvc.perform(post("/v1/fire_sms_code")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
                .andExpect(status().isOk());
    }

    // Utility method to convert object to JSON string
    private String asJsonString(Object obj) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(obj);
    }

    @Test
    public void checking_validate_sms_code() throws Exception {
        var request = new SMSValidateRequest("user_id_1", "2341");
        when(service.validSMSCode(request)).thenReturn(ResponseEntity.ok().build());

        mockMvc.perform(post("/v1/validate_sms_code")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(request)))
               .andExpect(status().isOk());
    }

}
