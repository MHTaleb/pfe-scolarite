/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application.controller.reservation;

import application.ajax.response.AjaxResponse;
import application.controller.login.LoginController;
import application.model.login.User;
import application.model.reservation.Reservation;
import application.model.salle.Salle;
import application.repositories.login.ReservationRepository;
import application.repositories.login.SalleRepository;
import application.service.mail.ContactMail;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author taleb
 * ce controlleur gere la reservation
 * il a deux requete preparé
 *     "/reservation/search"  : cella va repondre au client avec une liste de salle disponible dans la date de reservation desiré
 */
@RestController
public class ReservationController {

            @Autowired
            private SalleRepository salleRepository;

            @Autowired
            private ReservationRepository reservationRepository;
            
            @Autowired
            private HttpSession httpSession;
            
            //ici on va rechercher tout les salle disponible dans entre les date volu du clien
            @RequestMapping(value = "/reservation/search", method = RequestMethod.POST)
            public @ResponseBody AjaxResponse doSearch(@RequestBody SearchReserv searchReserv, Model model) {

                try {

                    System.out.println("current user : "+(User)httpSession.getAttribute("current_user"));
                    
                    System.out.println(searchReserv);
                    
                    ArrayList<ReservationSearchResponse> response = new ArrayList<>();
                    
                    model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
                    model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil
                    
                    // ici on execute la namedQuery qui nous donne la liste des salle disponible
                    List<Salle> salles = salleRepository.findByDisponibilite(searchReserv.getDateDebut(), searchReserv.getDateFin());
                    
                    // preparation d une reponse serveur vers le client
                    salles.stream().forEach(salle->{
                        response.add(new ReservationSearchResponse(salle.getId()+"","salle : "+ salle.getNomSalle() +" cap : "+salle.getCapacite() +" places"));
                    });

                    //renvois de la liste des salle
                    return new AjaxResponse("DONE", response);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new AjaxResponse("BAD", null);
                }

            }
            
            
            @RequestMapping(value = "/reservation/reserve", method = RequestMethod.POST)
            public @ResponseBody AjaxResponse doReserve(@RequestBody ReserveSalleForm form, Model model){
                try {
                    
                    Reservation reservation = new Reservation();
                    
                    reservation.setReserveur(LoginController.getConnected());
                    reservation.setDateDebut(form.getDateDebut());
                    reservation.setDateFin(form.getDateFin());
                    reservation.setSalle(salleRepository.findById(form.getId()).get());
                    
                    reservationRepository.save(reservation);
                    
                    
                    model.addAttribute("contactMail", new ContactMail());// envoyé l'utilisateur en cours a la nouvelle page
                    model.addAttribute("current_user", LoginController.getConnected()); // ajouter l utilisateur connecter en cours a la page d acceuil
                    
                    return new AjaxResponse("DONE", null);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new AjaxResponse("BAD", null);
                }
                    
            }
}
