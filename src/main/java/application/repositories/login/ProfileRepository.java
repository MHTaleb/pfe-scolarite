/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.repositories.login;

import application.model.login.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 */
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long>{
    
}
