/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.login;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author taleb
 */
@Entity
public class Message implements Serializable {
    

    @Id
    private Long id;

    
    @Basic
    private String message;
    
    @Basic 
    private String nom;
    
    @Basic 
    private String prenom;

    public Message() {
    }

    public Message(Long id, String message, String nom, String prenom) {
        this.id = id;
        this.message = message;
        this.nom = nom;
        this.prenom = prenom;
    }
    
    public String getMessage() {
        return message;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
