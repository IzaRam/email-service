package com.iza.it.service;

import com.iza.it.exception.EmailNotFoundException;
import com.iza.it.model.Email;
import org.springframework.data.crossstore.ChangeSetPersister;

public interface MailService {
    boolean sendMail(Email mail);

    boolean persistEmail(Email email);

    Iterable<Email> getEmailsByInterval(Long tmstBegin, Long tmstEnd);

    Email getEmailById(Integer id) throws EmailNotFoundException;
}
