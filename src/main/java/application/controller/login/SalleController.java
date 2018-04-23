/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.login;

import application.ajax.response.AjaxResponse;
import application.model.salle.Salle;
import application.repositories.login.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author taleb
 * 
 * controlleur de la page de gestion des salle
 * pas encore implementer
 */
@Controller
@PropertySource(ignoreResourceNotFound = true , value = "classpath:messages.properties")
@RequestMapping(SalleController.REST_PATH)
public class SalleController {
    
   public final static String REST_PATH = "/salles";
    
    @Autowired
    private AjaxResponse ajaxResponse;
    
    @Autowired
    private SalleRepository salleRepository;
    
    @DeleteMapping
    private @ResponseBody AjaxResponse deleteSalle(
            @RequestBody final SaleRequestParam saleRequestParam, Model model
    ){
        try {
            
            salleRepository.deleteById(saleRequestParam.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        ajaxResponse.setAnswer("DONE");
        ajaxResponse.setData(salleRepository.findAll());

        model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil

        return ajaxResponse;
    }
    
    @PutMapping
    private @ResponseBody AjaxResponse updateSalle(
            @RequestBody final SaleRequestParam saleRequestParam, Model model
    ){
      
        Salle salle = salleRepository.findById(saleRequestParam.getId()).get();
        salle.setCapacite(saleRequestParam.getCapacite());
        salle.setNomSalle(saleRequestParam.getNomSalle());
        try {
            
            salleRepository.save(salle);
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        ajaxResponse.setAnswer("DONE");
        ajaxResponse.setData(salleRepository.findAll());

        model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil

        return ajaxResponse;
    }
    
    @PostMapping
    private @ResponseBody AjaxResponse addSalle(
            @RequestBody final SaleRequestParam addSaleRequestParam, Model model
    ){
        
        Salle salle = new Salle();
        
        salle.setCapacite(addSaleRequestParam.getCapacite());
        salle.setNomSalle(addSaleRequestParam.getNomSalle());
        try {
            salleRepository.save(salle);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ajaxResponse.setAnswer("DONE");
        ajaxResponse.setData(salleRepository.findAll());
        
        model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil
                    
        return ajaxResponse;
    }

    private static class SaleRequestParam {

        private Long id;
        private Long capacite;
        private String nomSalle;
        
        public SaleRequestParam() {
        }

        public SaleRequestParam(Long id, Long capacite, String nomSalle) {
            this.id = id;
            this.capacite = capacite;
            this.nomSalle = nomSalle;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        
        public SaleRequestParam(Long capacite, String nomSalle) {
            this.capacite = capacite;
            this.nomSalle = nomSalle;
        }

        public Long getCapacite() {
            return capacite;
        }

        public String getNomSalle() {
            return nomSalle;
        }

        public void setCapacite(Long capacite) {
            this.capacite = capacite;
        }

        public void setNomSalle(String nomSalle) {
            this.nomSalle = nomSalle;
        }
                
    }
    
}
