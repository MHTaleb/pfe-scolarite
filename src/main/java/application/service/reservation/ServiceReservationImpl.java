/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.reservation;

import application.controller.login.LoginController;
import application.controller.login.ReservationForm;
import application.model.reservation.Reservation;
import application.model.salle.Salle;
import application.repositories.login.ReservationRepository;
import application.repositories.login.SalleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 */
@Component
public class ServiceReservationImpl implements ServiceReservation {

    @Autowired
    private SalleRepository salleRepository;
    
    @Autowired
    private ReservationRepository reservationRepository;
    
    @Override
    public boolean faireReservation(ReservationForm reservationForm) {
        
        List<Long> idSalleDisponible = reservationRepository.chercherReservation(
                reservationForm.getId(),
                reservationForm.getDateDebut(), 
                reservationForm.getDateFin()
        );
        
        if(idSalleDisponible != null) if(idSalleDisponible.isEmpty()){
            final Reservation reservation = new Reservation();
            reservation.setDateDebut(reservationForm.getDateDebut());
            reservation.setDateFin(reservationForm.getDateFin());
            reservation.setReserveur(LoginController.getConnected());
            Optional<Salle> salle = salleRepository.findById(reservationForm.getId());
            reservation.setSalle(salle.get());
            reservationRepository.save(reservation);
            
            return true;
        }
     
        
        return false;
    }
    
}
