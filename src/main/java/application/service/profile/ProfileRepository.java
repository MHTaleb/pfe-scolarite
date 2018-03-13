/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.service.profile;

import application.model.login.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author taleb
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    public Profile findByUser(@Param("userId") Long userId);
}
