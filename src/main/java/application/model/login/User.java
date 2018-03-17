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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author taleb
 * 
 * cette entity contien des requete nomé , @NamedQueries et @NamedQuery
 * l idée est simple spring data nous permet de creer une liste de requete @NamedQueries et y ajouter des  requetes
 * @NamedQuery
 * chaque @NamedQuery a deux champ obligatoir (name et query)
 * name est le nom de la requete qui dois etre unique par convention on nomme : Class.leNomDeRequete
 * query contient la requete ecrite en hql (hibernate query langage) ou jpql (java persistence query langage)
 * 
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
    @GeneratedValue(strategy = GenerationType.AUTO) // pour generer le id depuis un sequenceur 
    @Column(name = "user_id")
    private Long id;

    @Basic
    private String username;

    @Basic
    private String password;

    @Basic
    private String email;

    
    @OneToOne(targetEntity = Profile.class) // 1-->n  FetchTypeLazy : ne pas ramener les profil sauf si je demande par code avec la methode getUser_Profiles
    private Profile user_Profiles;
    
    public User() {
    }

    public User(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setUser_Profiles(Profile user_Profiles) {
        this.user_Profiles = user_Profiles;
    }

    public Profile getUser_Profiles() {
        return user_Profiles;
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
