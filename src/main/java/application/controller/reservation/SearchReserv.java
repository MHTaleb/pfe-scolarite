/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.reservation;

import java.time.LocalDate;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * une classe qui represente le model de requete depuis le client vers le serveur
 * 
 * cette class va correspondre au json envoyer par le clien qui cherche des salle disponible dans les date choisies
 */
@Component
public class SearchReserv {
    
    private LocalDate dateDebut;
    private LocalDate dateFin;
    
   

    public SearchReserv() {
    }

    public SearchReserv(LocalDate dateDebut, LocalDate dateFin) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
  
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "SearchReserv{" + "dateDebut=" + dateDebut + ", dateFin=" + dateFin + '}';
    }

    

   
    
    
    
}
