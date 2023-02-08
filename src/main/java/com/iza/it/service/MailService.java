package com.iza.it.service;

import com.iza.it.model.Email;

public interface MailService {
    boolean sendMail(Email mail);

    boolean persistEmail(Email email);
}
