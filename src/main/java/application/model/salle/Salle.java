/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.salle;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * entité des salles avec deux requete 
 * 
 *     la premiere pour trouver les salle avec un titre specifique
 *     la deuxieme est pour trouver les salles disponible dans un delai de reservation precis (date debut, date fin)
 * 
 * salle td salle tp laboratoir amphi si on vois bien se sont tous des salle avec des capacité diffirente
 * 
 * leur nature comportemental TD Amphi Labo  est tout simplement induite depuis le nom de la salle
 * 
 * par convention on peu nome une salle comme 
 * 
 * TD101  ou Lab203  ou AMP01  donc une encapsulation pour ajouter le champ type de salle serai pas obligatoir 
 * 
 * recherche tout les salle TD serai simplement de rechercher tout les salle don le nom commance par TD ( premiere requete )
 * 
 * l avantage avec un systeme de nomination on peu declarer autant de type de salle sans avoir besoin a changer dans la structure de la bdd
 * 
 */

@NamedQueries({
  @NamedQuery(name = "Salle.findByNomSalle" ,query = "SELECT e FROM Salle e WHERE e.nomSalle LIKE '%:nomSalle%'"),  
  @NamedQuery(name = "Salle.findByDisponibilite" ,query = "SELECT e FROM Salle e WHERE e NOT IN (SELECT r.salle from Reservation r WHERE (:dateDebut BETWEEN r.dateDebut  AND r.dateFin ) OR ( :dateFin  BETWEEN r.dateDebut AND r.dateFin) )")  
})
@Component
@Entity
public class Salle implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Basic
    @Column(unique = true)
    private String nomSalle;
    
    @Basic
    private Long capacite;

    public Salle() {
    }

    public Salle(Long id, String nomSalle, Long capacite) {
        this.id = id;
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }

    public Long getCapacite() {
        return capacite;
    }

    public void setCapacite(Long capacite) {
        this.capacite = capacite;
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

    @Override
    public String toString() {
        return "Salle{" + "id=" + id + ", nomSalle=" + nomSalle + ", capacite=" + capacite + '}';
    }
    
    
}
