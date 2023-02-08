package com.iza.it.consumer;

import org.springframework.messaging.handler.annotation.Payload;

public interface MailConsumer {
    void receiveNewMail(@Payload String mailInfo);
}
