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

/**
 *
 * @author taleb
 */
@Component
public class UserToUserForm implements Converter<User, UserForm>{

    @Override
    public UserForm convert(User user) {
        UserForm userForm = new UserForm();
        userForm.setId(user.getId());
        userForm.setEmail(user.getEmail());
        userForm.setPassword(user.getPassword());
        userForm.setUsername(user.getUsername());
        return userForm;
    }
    
}
