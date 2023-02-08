package com.iza.it.controller;

import com.iza.it.exception.EmailNotFoundException;
import com.iza.it.model.Email;
import com.iza.it.service.MailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mail")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping()
    public ResponseEntity<Email> getEmailById(@RequestParam Integer id) throws EmailNotFoundException {
        return new ResponseEntity<>(mailService.getEmailById(id), HttpStatus.OK);
    }

    @GetMapping("/interval")
    public ResponseEntity<Iterable<Email>> getEmailById(@RequestParam Long tmstBegin, @RequestParam Long tmstEnd) {
        return new ResponseEntity<>(mailService.getEmailsByInterval(tmstBegin, tmstEnd), HttpStatus.OK);
    }
}
