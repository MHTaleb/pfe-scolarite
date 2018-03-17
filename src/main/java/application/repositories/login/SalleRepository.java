/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repositories.login;

import application.model.salle.Salle;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 */
@Repository
public interface SalleRepository extends CrudRepository<Salle, Long>{
    public List<Salle> findByDisponibilite(@Param("dateDebut") LocalDate dateDebut,@Param("dateFin") LocalDate dateFin);
}
