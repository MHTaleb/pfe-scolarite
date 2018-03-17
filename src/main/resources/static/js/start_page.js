/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    //alert("is loading");

/**
 * enregistrer la methode ajax qui va demander au serveur d envoyer la liste des salle disponible
 * cette methode est lié grace au ID de l element forme dans le html
 * */
    $("#reserver_salle_form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_serach_salle();

    });
/**
 * enregistrer la methode qui va demander au serveur d envoyer un mail depui le formulaire
 * */
    $("#send_mail").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_send_mail();

    });

});

// recuperer le contenu du formulaire puis envoyer une requete post au serveur
function fire_serach_salle() {


    var searchReserv = {};

    //preparer le contenu de la requete
    searchReserv["dateDebut"] = $("#dateDebut").val();
    searchReserv["dateFin"] = $("#dateFin").val();
    
    // desactiver le bouton de recherche
    $("#searchSalle").prop("disabled", true);

    $.ajax({
        //preparé la requete de type Post comme dans le controlleur dans le serveur
        type: "POST",
        // specifier qu on va communiquer avec du json
        contentType: "application/json",
        // specifier l addresse du controlleur
        url: "/reservation/search",
        //transformer le contenu depuis le tableau en haut a un document json
        data: JSON.stringify(searchReserv),
        // signé le document au format json
        dataType: 'json',
        //effacer requete une fois envoyé
        cache: false,
        //temps d attente d une reponse serveur
        timeout: 900000,

        // si l envoie est reussi et le serveur repond qu il a bien traiter la demande
        success: function (result) {
            // result est ce que le serveur envoi en reponse
            if (result.answer === "DONE") { // on verifie que le serveur a envoyer un message Done qui signifie que tt va bien
                 var quote = "'";// on prepare la liste des salle avec un javascript qui va ajouter des html a un div vide dans la page qui a le ID salleList
                /*<![CDATA[*/
                var html = '<div class="w3-container">\n\
                     <span onclick="document.getElementById('+quote+'id01'+quote+').style.display='+quote+'none'+quote+'" class="w3-button w3-display-topright">&times;</span>';
                html += '<h2>Liste des salles </h2>';
                html += '<ul  class="w3-ul w3-hoverable">';
                for (var i = 0; i < result.data.length; i++) { // pour chaque salle dans la reponse on va ajouter un element a la liste qui a comme methode reserver avec le id de la salle
                    html += ' <li id="'+ result.data[i].idSalle +'" class="w3-display-container ">' + result.data[i].title + '-' + '<span onclick="reserve(' + result.data[i].idSalle + ')" class="w3-button w3-transparent w3-display-right w3-hover-green">reserver</span></li>';
                }
                html += '</ul> </div>';
                /*]]>*/
                $("#salleList").html(html);
                //Afficher la liste des salle
                document.getElementById('id01').style.display='block';
                // reactiver la recherche
                $("#searchSalle").prop("disabled", false);
                
            }
        }
    });



}

function reserve(id) {
    
    var sendReservRequest = {};
    // on prepare les element de la reservation
    sendReservRequest["id"] = id;
    sendReservRequest["dateDebut"] = $("#dateDebut").val();
    sendReservRequest["dateFin"] = $("#dateFin").val();
    
    
    $.ajax({
        // preparation de l envoie de requete avec le doc json
        type: "POST",
        contentType: "application/json",
        url: "/reservation/reserve",
        data: JSON.stringify(sendReservRequest),
        dataType: 'json',
        cache: false,
        timeout: 900000,

        success: function (result) {
            if (result.answer === "DONE") {
                 alert("Reservation reussie");
                 //si la reservation est bien faite  on suprime le element de la liste qu on vien de reserver
                 $("#"+ id ).remove();
                 
            }else{
                alert("Echec de reservation Veuillez contacter l adminitrateur");
            }
            
            
        }
    });

}

function fire_send_mail() {

// envoi de mail ajax
    var contactMail = {};
//desactiver bouton du envoi mail
    $("#sendmailbutton").prop("disabled", true);
// preparation des element 
    contactMail["nom"] = $("#nom").val();
    contactMail["prenom"] = $("#prenom").val();
    contactMail["message"] = $("#message").val();


    $.ajax({
        //requete ajax
        type: "POST",
        contentType: "application/json",
        url: "/homePage/contact",
        data: JSON.stringify(contactMail),
        dataType: 'json',
        cache: false,
        timeout: 900000,

        success: function (result) {
            if (result.answer === "DONE") {
                //si le mail est envoyer on affiche alert que c est envoyer et on vide formulaire et on reactive le bouton de l envoi
                alert("Message envoyer");
                $("#sendmailbutton").prop("disabled", false);
                $("#nom").prop("value", "");
                $("#prenom").prop("value", "");
                $("#message").prop("value", "");
            }
        }
    });


}