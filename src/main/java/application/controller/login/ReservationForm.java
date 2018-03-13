/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import java.util.Date;

/**
 *
 * @author taleb
 */
public class ReservationForm {
    
    private Long id;
    private Date dateDebut;
    private Date dateFin;

    public ReservationForm() {
    }

    public ReservationForm(Long id, Date dateDebut, Date dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    
    
    
}
