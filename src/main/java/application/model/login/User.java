/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.model.login;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author taleb
 */
@Entity(name = "user_table")
@NamedQueries({
    @NamedQuery(
            name = "User.findByCredential", 
            query = " SELECT e FROM user_table e LEFT JOIN FETCH e.user_Profiles WHERE e.password = :password AND ( e.username = :username OR e.email = :username )")
,    
    @NamedQuery(
            name = "User.getAll", 
            query = " SELECT e FROM user_table e JOIN FETCH e.user_Profiles ")
,    
    @NamedQuery(
            name = "User.getAllByProfile", 
            query = " SELECT e FROM user_table e JOIN FETCH e.user_Profiles WHERE :profile = ANY (SELECT p from e.user_Profiles p) ")    
}
)

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id",referencedColumnName = "user_id")
    private List<Profile> user_Profiles;
    
    public User() {
    }

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public List<Profile> getUser_Profile() {
        return user_Profiles;
    }

    public void setUser_Profile(List<Profile> user_Profile) {
        this.user_Profiles = user_Profile;
    }
    
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
/*
    public void addProfile(Profile profile){
        
    }
    
    public void removeProfile(Profile profile){
        
    }
*/

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", user_Profiles=" + user_Profiles + '}';
    }
    
}
