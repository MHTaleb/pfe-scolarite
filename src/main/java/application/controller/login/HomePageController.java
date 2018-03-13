/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import application.service.mail.ContactMail;
import application.service.mail.MailContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taleb
 */
        @RestController
        @PropertySource(ignoreResourceNotFound = true , value = "classpath:messages.properties")
        public class HomePageController {

            @Autowired
            private MailContactService mailService;

            @RequestMapping(value = "/homePage/contact", method = RequestMethod.POST)
            public String sendMessage(@RequestBody ContactMail contactMail, Model model){
                mailService.sendContactMail(contactMail);
                System.out.println("done");
                model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
                model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil
          
                return "/home/start_page";

            }


        }
