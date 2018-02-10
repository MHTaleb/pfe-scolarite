/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import application.converter.login.UserFormToUser;
import application.form.adapter.login.UserForm;
import application.model.login.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import application.service.login.LoginService;
import application.service.login.LoginServiceImpl;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 *
 * @author taleb
 */
@Controller
@PropertySource(ignoreResourceNotFound = true , value = "classpath:messages.properties")
public class LoginController {
    
    @Value("${login.error.message}")
    private String login_error_message;
    
    @Value("${register.error.message}")
    private String register_error_message;
    
    
    private LoginService loginService;

    @Autowired
    public void setLoginService(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }
    
    
    @RequestMapping({"/login"})
    public String loginPage(Model model){
        model.addAttribute("userForm", new UserForm());
        return "login/index";
    }

    @RequestMapping(path = "/login/connect",method = RequestMethod.POST)
    public String doLogin(UserForm userForm,Model model){
        
        User connected = loginService.connect(userForm.getUsername(), userForm.getPassword());
        if (connected.getUsername().equals("-1")) {
            model.addAttribute("login_error_message",login_error_message);
            return "redicrect:login/index";
        }else{
            model.addAttribute("current_user", connected);
            return "redirect:ladingpage/home";
        }
    }
   
    @Autowired
    private UserFormToUser formToUser;

    @RequestMapping(path = "/login/register",method = RequestMethod.POST)
    public String doRegister(UserForm userForm,Model model){
        
        System.out.println("starting registration ....");
        System.out.println("user  : "+userForm.getUsername());
        System.out.println("email : "+userForm.getEmail());
        System.out.println("password : "+userForm.getPassword());
        
        User registred = loginService.register(userForm.getUsername(), userForm.getEmail(), userForm.getPassword());
        
        if (registred.getUsername().equals("-1")) {
            model.addAttribute("register_error_message",register_error_message);
            System.out.println("starting registration ....");
            return "redicrect:login/index";
        }else{
            model.addAttribute("current_user", registred);
            System.out.println("starting registration ....");
            return "redirect:ladingpage/home";
        }
    }
   
    
    
}
