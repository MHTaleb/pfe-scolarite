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
