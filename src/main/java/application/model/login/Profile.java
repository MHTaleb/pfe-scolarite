/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.login;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author taleb
 * 
 * l entité profile
 * pour qu une class devienne une entité on a besoin en minimum de 
 * 
 * @Entity cela va dire a spring que cela est une entité
 * 
 * @Id avant un champ pour dire que j ai un id dans cette entité
 * 
 * spring data nous donne d autre anotation
 * 
 * @Basic pour declarer un champ normal
 * 
 * @OneToOne,OneToMany,ManyToMany,ManyToOne pour creer des relation d ordre de 1-->1 1-->n  n-->n    n-->1
 * 
 * ce genre de  class doit etre un POJO (plain old java object ) cela veux dire des champs privé
 * avec des accesseur et de muttateur et deux constructeur 1:vide 2:plain
 * 
 */

@Entity(name = "profile")
public class Profile implements Serializable{

    @Id
    @Column(name = "profile_id")
    private Long id;

    @Basic
    private String profile_name;

    public Profile() {
    }

    public Profile(Long id, String profile_name) {
        this.id = id;
        this.profile_name = profile_name;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setProfile_name(String profile_name) {
        this.profile_name = profile_name;
    }    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
