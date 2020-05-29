package nl.kolkos.chapter2.bootcustomernotification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Mailer {
    private final JavaMailSender javaMailSender;

    public void sendMail(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Registration");
        mailMessage.setText("Successfully registered");
        javaMailSender.send(mailMessage);
    }
}
