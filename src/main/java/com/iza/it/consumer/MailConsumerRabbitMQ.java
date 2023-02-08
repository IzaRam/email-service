package com.iza.it.consumer;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.iza.it.model.Email;
import com.iza.it.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class MailConsumerRabbitMQ implements MailConsumer{

    Logger logger = LoggerFactory.getLogger(MailConsumerRabbitMQ.class);

    private final MailService mailService;

    public MailConsumerRabbitMQ(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    @RabbitListener(queues = {"${queue.mail}"})
    public void receiveNewMail(@Payload String mailInfo) {
        logger.info("New e-mail received: " + mailInfo);

        Gson gson = new Gson();
        try {
            Email mail = gson.fromJson(mailInfo, Email.class);

            if (mailService.persistEmail(mail)) logger.info("Email saved successfully");
            else logger.info("Failed to persist email");

            if (mailService.sendMail(mail)) logger.info("Email successfully sent: " + mail);
            else logger.info("Failed to send email: " + mail);
        } catch (JsonSyntaxException e) {
            logger.info("Failed to parse email content");
        }

    }
}
