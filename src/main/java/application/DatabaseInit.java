/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import application.model.login.Profile;
import application.model.login.ProfileType;
import application.model.login.User;
import application.repositories.login.LoginRepository;
import application.repositories.login.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 */
@Component
public class DatabaseInit implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private LoginRepository repo;

    @Autowired
    private ProfileRepository profileRepository;

    public void init() {

        long usersCount;
        try {
            usersCount = repo.count();

        } catch (Exception e) {
            usersCount = 0;
        }

        if (usersCount == 0) {

            User u = new User();

            u.setEmail("admin@mail.com");
            u.setPassword("admin");
            u.setUsername("admin");

            final Profile profileAdmin = new Profile(Long.valueOf(1), "ADMINISTRATEUR");
            profileAdmin.setProfileType(ProfileType.ADMIN);
            final Profile profileEnseignant = new Profile(Long.valueOf(2), "ENSEIGNANT");
            profileEnseignant.setProfileType(ProfileType.ENSEIGNANT);

            profileRepository.save(profileAdmin);
            profileRepository.save(profileEnseignant);

            u.setUser_Profiles(profileAdmin);

            repo.save(u);

        }

    }

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        init();
    }
}
