/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repositories.login;

import application.model.salle.Salle;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author taleb
 */
public interface SalleRepository extends CrudRepository<Salle, Long>{
    
}
