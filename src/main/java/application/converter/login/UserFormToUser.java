/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.converter.login;

import application.form.adapter.login.UserForm;
import application.model.login.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 *
 * @author taleb
 */
@Component
public class UserFormToUser implements Converter<UserForm, User>{

    @Override
    public User convert(UserForm userForm) {
        
        User user =new User();
        if (userForm.getId() != null && !StringUtils.isEmpty(userForm.getId())) {
            user.setId(userForm.getId()+0);
        }
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setUsername(userForm.getUsername());
        return user;
    }
    
}
