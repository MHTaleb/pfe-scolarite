/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.mail;

import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * class qui represente la structure du Json envoyer depuis le formualire clien vers le serveur pour l envoi d u mail 
 * 
 */
@Component
public class ContactMail {
    private String nom;
    private String prenom;
    private String message;

    public ContactMail() {
    }

    public ContactMail(String nom, String prenom, String message) {
        this.nom = nom;
        this.prenom = prenom;
        this.message = message;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMessage() {
        return message;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ContactMail{" + "nom=" + nom + ", prenom=" + prenom + ", message=" + message + '}';
    }
 
    
    
}
