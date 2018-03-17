/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import application.form.adapter.login.UserForm;
import application.model.login.Profile;
import application.model.login.ProfileType;
import application.model.login.User;
import application.repositories.login.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import application.service.login.LoginService;
import application.service.login.LoginServiceImpl;
import application.service.mail.ContactMail;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author taleb
 * 
 * LoginController est la class qui va gerer les action des formulaire et la pagination
 * l annotation @Controller indique a spring que cette class va gerer des methodes appeler par le client
 * ou rediriger le client a une page specifique
 * 
 * @PropertySource indique a spring que dans ce controlleur on va charger le fichier messages.properties
 */
@Controller
@PropertySource(ignoreResourceNotFound = true , value = "classpath:messages.properties")
public class LoginController {
    
    //initialisation de la variable login_error_message par le contenu de login.error.message
    @Value("${login.error.message}")
    private String login_error_message;
    
    @Value("${register.error.message}")
    private String register_error_message;
    
    //une interface qui a l ensemble des methodes concernant le login
    private LoginService loginService;

    // ce constructeur va etre appeler par spring pour initialiser le : loginService
    @Autowired
    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }
    
    //la methode qui va etre appeler si on va sur localhost:8181 ou localhost:8181/login
    @RequestMapping({"/login","/"})
    public String loginPage(Model model){
        //on va initialiser un objet DTO (UserForm) et le donner a la page index.html qui va etre necessaire 
        //   pour le formulaire de connexion
        model.addAttribute("userForm", new UserForm());
        // redirection vers la page d acceuil index.html
        return "login/index";
    }

    //meme chose que la methode en haut
    @RequestMapping({"/login/error"})
    public String loginPageError(Model model){
        model.addAttribute("userForm", new UserForm());
        return "login/index";
    }

    // la methode qui va gerer la connexion
    @RequestMapping(path = "/login/connect",method = RequestMethod.POST)
    public String doLogin(UserForm userForm,Model model){
        // userForm est le post du formulaire de connexion
        
        //appeler la methode connect du service
        
        connected = loginService.connect(userForm.getUsername(), userForm.getPassword());
        
        if (connected.getUsername().equals("-1")) { // si la methode retourne un objet contennant -1 connexion echouer
            model.addAttribute("login_error_message",login_error_message);//preparé le message d erreur pour la page
            return "/login/index";// rediriger vers la meme page mais cette fois avec un message d erreur en plus
        }else{//connexion reussie
            final Profile profile = new Profile();
            profile.setProfileType(ProfileType.ENSEIGNANT);
            connected.setUser_Profiles(profile);
            
            model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
            model.addAttribute("current_user", connected);// envoyé l'utilisateur en cours a la nouvelle page
            return "/home/start_page";// redirection vers la page d acceuil start_page.html
        }
    }
   
    private static User connected;

    public static User getConnected() {
        return connected;
    }
  
    
    @Autowired
    private SalleRepository salleRepository;
    
    //La methode qui va etre appeler en cas d enregistrement d  un nouveau utilisateur
    @RequestMapping(path = "/login/register",method = RequestMethod.POST)
    public String doRegister(UserForm userForm,Model model){
        // appeler la methode qui ajoute un utilisateur : loginService.register
        connected = loginService.register(userForm.getUsername(), userForm.getEmail(), userForm.getPassword());
        
        if (connected.getUsername().equals("-1")) {// si l ajout a achouer on retourne a la page de connection
            model.addAttribute("register_error_message",register_error_message);// ajouter un message d erreur
            return "/login/index";// index.html
        }else{
            final Profile profile = new Profile();
            profile.setProfileType(ProfileType.ENSEIGNANT);
            connected.setUser_Profiles(profile);
            
            model.addAttribute("salles", salleRepository.findAll() );// envoyé l'utilisateur en cours a la nouvelle page
            model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
            model.addAttribute("current_user", connected); // ajouter l utilisateur connecter en cours a la page d acceuil
            return "/home/start_page";//aller a la page d'acceuil
        }
    }
   
    
    
}
