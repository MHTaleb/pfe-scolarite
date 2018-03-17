/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.reservation;

/**
 *
 * @author taleb
 * 
 * une class qui va representer le modele de reponse du serveur vers le clien
 * 
 * cela va nous permettre de lier entre ajax et le serveur spring qui von communiquer avec des document json
 * qui seron formater celon cette class
 * 
 */
public class ReservationSearchResponse {
    private String idSalle;
    private String title;

    public ReservationSearchResponse(String ID, String title) {
        this.idSalle = ID;
        this.title = title;
    }

    public void setIdSalle(String idSalle) {
        this.idSalle = idSalle;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdSalle() {
        return idSalle;
    }

    public String getTitle() {
        return title;
    }

    
    
    
}
