/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.login;

import application.model.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import application.repositories.login.LoginRepository;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * cette class est une implementation des la logique de connexion et d enregistrement
 */
@Component
public class LoginServiceImpl implements LoginService {

    // spring initialise cette variable avec le IOC : inversion of control
    @Autowired
    private LoginRepository loginRepository;

    // methode implementant la logique de conenxion
    @Override
    public User connect(String username, String password) {
        // appeller la requete nomé qui permet la connexion
        List<User> u = loginRepository.findByCredential(username, password);
        
        //si l utilisateur n existe pas
        if (u == null) {
            //alor on retourne un nouveau utilisateur dans les champ egale a -1
            return new User(new Long(-1), "-1", "-1", "-1");
        }
        //sinon on va retourné l utilisateur trouver avec l appel de la requete nomé
        return u.get(0);
    }

    //logique d enregistrement d un nouveau utilisateur
    @Override
    public User register(String username, String email, String password) {

        User user = new User(); // creer une nouvelle instance
        try {

            user.setEmail(email);//mettre le email ...
            user.setPassword(password);
            user.setUsername(username);
            List<User> users = loginRepository.findByCredential(username, password);
            if(users.isEmpty()){
                loginRepository.save(user);
            }else{
                return users.get(0);
            }
            // enregistrer l objet dans la bdd

        } catch (Exception e) {
            return new User(new Long(-1), "-1", "-1", "-1"); // en cas d erreur on retourn un objet -1
        }
        // enregistrement bien effectué on retourne le user enregistrer
        return user;

    }

}
