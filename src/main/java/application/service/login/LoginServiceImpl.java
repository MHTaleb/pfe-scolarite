/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.login;

import application.model.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import application.repositories.login.LoginRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 */
@Component
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public User connect(String username, String password) {
        System.out.println("username = "+username);
        System.out.println("password = "+password);
        User u = loginRepository.findByCredential(username, password);
        System.out.println(u);
        if (u == null) {
            return new User(new Long(-1), "-1", "-1", "-1");
        }
        return u;
    }

    @Override
    public User register(String username, String email, String password) {

        User user = new User();
        try {

            user.setEmail(email);
            user.setPassword(password);
            user.setUsername(username);
            loginRepository.save(user);
        } catch (Exception e) {
            return new User(new Long(-1), "-1", "-1", "-1");
        }

        return user;

    }

}
