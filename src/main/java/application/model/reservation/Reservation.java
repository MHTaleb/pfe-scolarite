/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.reservation;

import application.model.login.User;
import application.model.salle.Salle;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author taleb
 */

@NamedQueries({
    @NamedQuery(name = "Reservation.chercherReservation",
                query = "SELECT e.salle.id FROM Reservation e WHERE e.dateDebut > :dateFin OR e.dateFin < :dateDebut ")
})

@Entity
public class Reservation implements Serializable {

    @Id
    private Long id;

    @Basic
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebut;

    @Basic
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFin;

    @OneToOne(targetEntity = User.class)
    private User reserveur;

    @OneToOne(targetEntity = Salle.class)
    private Salle salle;

    public Reservation() {
    }

    public Reservation(Date dateDebut, Date dateFin, User reserveur, Salle salle, Long id) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.reserveur = reserveur;
        this.salle = salle;
        this.id = id;
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

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

}
