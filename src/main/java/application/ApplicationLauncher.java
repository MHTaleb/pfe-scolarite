package application;

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
