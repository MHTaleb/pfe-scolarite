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
 */
@Repository
public interface LoginRepository extends CrudRepository<User, Long>{
    public User findByCredential(@Param("username") String username,@Param("password")  String password);
}
