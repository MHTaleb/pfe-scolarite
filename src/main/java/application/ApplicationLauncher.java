package application;

import application.model.login.Profile;
import application.model.login.ProfileType;
import application.model.login.User;
import application.repositories.login.LoginRepository;
import application.repositories.login.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApplicationLauncher {

    
    
    public static void main(String[] args) {
        
        
        /**
         * cette class lance le serveur apache grace a l annotation
         * @SpringBootApplication
         * 
         * l ordre de lancement : 
         *     1- context spring
         *     2- serveur apache
         *     3- spring data (gestion de persistance)
         *     4- spring web mvc ( gestion des servlet et du mapping )
         * 
         */
        SpringApplication.run(ApplicationLauncher.class, args);
  
        
        }
}
