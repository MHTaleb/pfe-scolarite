/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.ajax.response;

import org.springframework.stereotype.Component;

/**
 *
 * @author taleb
 * 
 * cette classe represente l object qu on va envoyer a ajax
 * 
 * ajax est une bibliotheque basé sur javascript qui nous permet d envoyer des requete serveur sans devoir rafraichir 
 * on peu meme ajouter du traitement coté client selon la reponse du serveur
 * 
 */
@Component
public class AjaxResponse {
    
    private String answer; // un message qui nous aidera a comprendre la nature de la reponse
    private Object data; // un objet contenant la reponse du serveur
    

    public AjaxResponse() {
    }

    public AjaxResponse(String answer, Object data) {
        this.answer = answer;
        this.data = data;
    }

    public String getAnswer() {
        return answer;
    }

    public Object getData() {
        return data;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
    
}
