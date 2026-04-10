package com.example.mongo.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(String para, String mensagem) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(para);
        mail.setSubject("Login realizado");
        mail.setText(mensagem);

        mailSender.send(mail);
    }
}