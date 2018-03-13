/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 *
 * @author taleb
 */
@Service
public class MailContactService {
    @Autowired
    private JavaMailSender mailSender;
    
    public void sendContactMail(ContactMail contactMail) throws MailException{
     
        System.out.println(contactMail);
        
        SimpleMailMessage mailMessage =  new SimpleMailMessage();
        mailMessage.setTo("pfe.scolarite.13@gmail.com");
        mailMessage.setFrom("pfe.scolarite.13@gmail.com");
        mailMessage.setSubject(contactMail.getNom()+" "+contactMail.getPrenom());
        mailMessage.setText(contactMail.getMessage());
        
        mailSender.send(mailMessage);
    }
}
