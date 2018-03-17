/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import application.ajax.response.AjaxResponse;
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
 * 
 * cette class est le controlleur qui va gerer l envoi du message
 * 
 */
@RestController // pour declarer a spring que cela est un controlleur
@PropertySource(ignoreResourceNotFound = true, value = "classpath:messages.properties") // declarer a spring l endroit du fichier properties qui contien qlq message predefini
public class HomePageController {

    @Autowired
    private MailContactService mailService; // service de mail : implementation de la logique d envoi

    @RequestMapping(value = "/homePage/contact", method = RequestMethod.POST) // reception de la requete request
    public AjaxResponse sendMessage(@RequestBody ContactMail contactMail, Model model) { //ContactMail est la class de l objet qui represnte ce que le client a envoyer dans le formulaire

        mailService.sendContactMail(contactMail);// on laisse le service s occupé de la requete de mail

        System.out.println("done");

        model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
        model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil

        return new AjaxResponse("DONE", null);

    }

}
