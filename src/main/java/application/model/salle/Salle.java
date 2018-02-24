/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.salle;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author taleb
 * 
 * entité des salles
 */

@NamedQueries({
  @NamedQuery(name = "Salle.findByNomSalle" ,query = "SELECT e FROM Salle e WHERE e.nomSalle LIKE '%:nomSalle%'")  
})

@Entity
public class Salle implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Basic
    private String nomSalle;

    public Salle() {
    }

    public Salle(Long id, String nomSalle) {
        this.id = id;
        this.nomSalle = nomSalle;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }
    
    
}
