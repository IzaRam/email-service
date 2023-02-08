package com.iza.it.service;

import com.iza.it.model.Email;
import com.iza.it.repository.MailRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpExample implements MailService{

    private final MailRepository mailRepository;

    private final JavaMailSender javaMailSender;

    public MailServiceImpExample(MailRepository mailRepository, JavaMailSender javaMailSender) {
        this.mailRepository = mailRepository;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public boolean sendMail(Email mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mail.getFromService());
        message.setTo(mail.getToClient());
        message.setText(mail.getMessage());
        try {
            javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean persistEmail(Email email) {
        try {
            mailRepository.save(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
