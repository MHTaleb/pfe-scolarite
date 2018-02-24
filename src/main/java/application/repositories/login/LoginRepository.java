/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repositories.login;

import application.model.login.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 * 
 * dans spring pour pouvoir creer des elment dans une table de donnée on a l'interface CrudRepository
 * qui as tout ce qui est necessaire pour ; Create(creer un ligne) Research(rechercher) Update(mise a jour) Delete(supprimer)
 * 
 */
@Repository
public interface LoginRepository extends CrudRepository<User, Long>{
    /**
     * pour se servir d une requete nomé il suffit de creer une methode avec le mem nom de la requete
     * pour les paramaitre de la requete il suffit d ajouter @Param pour indiquer que la variable ets 
     * lié a quel paramaitre de la requete
     * 
     * @NamedQuery(
            name = "User.findByCredential", 
            query = " SELECT e FROM user_table e LEFT JOIN FETCH e.user_Profiles 
     *        WHERE e.password = :password AND ( e.username = :username OR e.email = :username )")
     *  ici on indique que String username est le meme paramaitre :username dans la requete
     */
    public User findByCredential(@Param("username") String username,@Param("password")  String password);
}
