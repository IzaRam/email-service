package com.iza.it.service;

import com.iza.it.exception.EmailNotFoundException;
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
            email.setTmst(System.currentTimeMillis());
            mailRepository.save(email);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Iterable<Email> getEmailsByInterval(Long tmstBegin, Long tmstEnd) {
        return mailRepository.findEmailByTmstInterval(tmstBegin, tmstEnd);
    }

    @Override
    public Email getEmailById(Integer id) throws EmailNotFoundException {
        return mailRepository.findById(id).orElseThrow(() -> new EmailNotFoundException("Email not found with id: " + id));
    }
}
