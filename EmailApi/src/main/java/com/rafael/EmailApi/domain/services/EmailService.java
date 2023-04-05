package com.rafael.EmailApi.domain.services;

import com.rafael.EmailApi.domain.dtos.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(EmailDTO emailDTO) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(emailDTO.getEmailBody(), true);
            mimeMessageHelper.setTo(emailDTO.getTo());
            mimeMessageHelper.setSubject(emailDTO.getSubject());
            mimeMessageHelper.setFrom(emailDTO.getFrom());
            javaMailSender.send(mimeMessage);
        } catch(MessagingException e) {
            throw new IllegalStateException("Falha ao enviar email.");
        }
    }
}



