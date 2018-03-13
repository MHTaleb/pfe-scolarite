/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.reservation;

import application.controller.login.ReservationForm;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 */
@Component
public interface ServiceReservation {
    public boolean faireReservation(ReservationForm reservationForm);
}
