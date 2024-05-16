package com.contact.smspush.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sms")
public class SMSSent {
    @Id
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "code")
    private String code;
    @Column(name = "user_id")
    private String userId;
}
