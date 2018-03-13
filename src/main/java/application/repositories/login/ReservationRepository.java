/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repositories.login;

import application.model.reservation.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{
    
    public List<Long> chercherReservation(@Param("idSalle") Long idSalle,@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    
}
