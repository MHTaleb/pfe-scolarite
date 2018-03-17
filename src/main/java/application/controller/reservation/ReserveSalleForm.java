/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.reservation;

import java.time.LocalDate;

/**
 *
 * @author taleb
 * une classe qui represente ce que le serveur va recevoir depuis le client comme json qui contient les critere de recherche d une
 * ou plusieur salle disponible
 * 
 */
public class ReserveSalleForm {
    
    private Long id; // id de la salle choisis a reserver
    private LocalDate dateDebut; // date debut reservation
    private LocalDate dateFin; // date fin reservation

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Long getId() {
        return id;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReserveSalleForm() {
    }

    public ReserveSalleForm(Long id, LocalDate dateDebut, LocalDate dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    
    
    
}
