package com.contact.smspush.repository;

import com.contact.smspush.model.entities.SMSSent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface SMSRepository extends JpaRepository<SMSSent, Long> {

    Optional<SMSSent> findByPhoneNumber(String phoneNumber);

    Optional<SMSSent> findByUserId(String userId);

}
