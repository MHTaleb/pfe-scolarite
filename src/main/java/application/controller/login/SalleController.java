/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;

/**
 *
 * @author taleb
 */
@Controller
@PropertySource(ignoreResourceNotFound = true , value = "classpath:messages.properties")
public class SalleController {
    
}
