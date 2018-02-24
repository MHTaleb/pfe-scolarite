/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.login;

import application.model.login.User;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * une simple interface qui va contenir nos methode de login et register
 * 
 * @component aide spring a reconnaitre  cette class
 * 
 */
@Component
public interface LoginService {
 
    User connect(String username,String password);
    User register(String username,String email,String password);
}
