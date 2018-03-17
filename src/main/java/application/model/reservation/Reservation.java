/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.reservation;

import application.model.login.User;
import application.model.salle.Salle;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author taleb
 * 
 * entité des reservation 
 * 
 * on defini une reservation par une relation entre un utilisateur et une salle dans une periode definie
 * 
 * 
 */


@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private LocalDate dateDebut;

    @Basic
    private LocalDate dateFin;

    @OneToOne(targetEntity = User.class)
    private User reserveur;

    @OneToOne(targetEntity = Salle.class)
    private Salle salle;

    public Reservation() {
    }

    public Reservation(Long id, LocalDate dateDebut, LocalDate dateFin, User reserveur, Salle salle) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reserveur = reserveur;
        this.salle = salle;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public User getReserveur() {
        return reserveur;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setReserveur(User reserveur) {
        this.reserveur = reserveur;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
