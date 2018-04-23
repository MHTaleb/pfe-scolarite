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
    
/**
 * enregistrer la methode qui va demander au serveur d envoyer un mail depui le formulaire
 * */
    $("#send_mail").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_send_mail();

    });

});

function requestModifierSalle(){
    var updateSalleRequestParam = {};
    
    
    updateSalleRequestParam["id"] = $("#idSalle").val();
    updateSalleRequestParam["nomSalle"] = $("#nomSalle").val();
    updateSalleRequestParam["capacite"] = $("#capacite").val();
    
    $("#modifierSalleButton").prop("disabled", true);
    
    $.ajax({
        //preparé la requete de type Post comme dans le controlleur dans le serveur
        type: "PUT",
        // specifier qu on va communiquer avec du json
        contentType: "application/json",
        // specifier l addresse du controlleur
        url: "/salles",
        //transformer le contenu depuis le tableau en haut a un document json
        data: JSON.stringify(updateSalleRequestParam),
        // signé le document au format json
        dataType: 'json',
        //effacer requete une fois envoyé
        cache: false,
        //temps d attente d une reponse serveur
        timeout: 900000,

        // si l envoie est reussi et le serveur repond qu il a bien traiter la demande
        success: function (result) {
            if (result.answer === "DONE") { 
            
                var quote = "'";// on prepare la liste des salle avec un javascript qui va ajouter des html a un div vide dans la page qui a le ID salleList
                /*<![CDATA[*/
                var html = '<input placeholder='+quote+'rechercher'+quote+' class='+quote+' w3-input '+quote+' id='+quote+'searchSalleValue'+quote+' onkeyup='+quote+'searchSalle()'+quote+' />';
                for (var i = 0; i < result.data.length; i++) { // pour chaque salle dans la reponse on va ajouter un element a la liste qui a comme methode reserver avec le id de la salle
                    html +=  '<li class='+quote+'w3-display-container'+quote+' > &nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src="/salle.png" />&nbsp;&nbsp;&nbsp;'+result.data[i].nomSalle+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src='+quote+'/chaise.png'+quote+' />'+result.data[i].capacite+'<div class='+quote+'w3-display-right'+quote+'> <span onclick="modifierSalle('+result.data[i].nomSalle+','+result.data[i].capacite+','+result.data[i].id+')" class=" w3-button w3-transparent "> <img class="w3-image" src="/edit.png" /></span><span onclick="supprimerSalle('+result.data[i].id+')"  class="w3-button w3-transparent "><img class="w3-image" src="/delete.png" /></span></div>';
                }
                /*]]>*/
                $("#salleListView").html(html);
                
                $("#modifierSalleButton").prop("disabled", false);
                $("#hideUpdateButton").click();
            }

        }
        
    });
}

function supprimerSalle(id){
    
    var delRequest = {};
    
    delRequest["id"] = id;
    
    $.ajax({
        //preparé la requete de type Post comme dans le controlleur dans le serveur
        type: "DELETE",
        // specifier qu on va communiquer avec du json
        contentType: "application/json",
        // specifier l addresse du controlleur
        url: "/salles",
        //transformer le contenu depuis le tableau en haut a un document json
        data: JSON.stringify(delRequest),
        // signé le document au format json
        dataType: 'json',
        //effacer requete une fois envoyé
        cache: false,
        //temps d attente d une reponse serveur
        timeout: 900000,

        // si l envoie est reussi et le serveur repond qu il a bien traiter la demande
        success: function (result) {
            if (result.answer === "DONE") { 
            
                var quote = "'";// on prepare la liste des salle avec un javascript qui va ajouter des html a un div vide dans la page qui a le ID salleList
                /*<![CDATA[*/
                var html = '<input placeholder='+quote+'rechercher'+quote+' class='+quote+' w3-input '+quote+' id='+quote+'searchSalleValue'+quote+' onkeyup='+quote+'searchSalle()'+quote+' />';
                for (var i = 0; i < result.data.length; i++) { // pour chaque salle dans la reponse on va ajouter un element a la liste qui a comme methode reserver avec le id de la salle
                    html +=  '<li class='+quote+'w3-display-container'+quote+' > &nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src="/salle.png" />&nbsp;&nbsp;&nbsp;'+result.data[i].nomSalle+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src='+quote+'/chaise.png'+quote+' />'+result.data[i].capacite+'<div class='+quote+'w3-display-right'+quote+'> <span onclick="modifierSalle('+result.data[i].nomSalle+','+result.data[i].capacite+','+result.data[i].id+')" class=" w3-button w3-transparent "> <img class="w3-image" src="/edit.png" /></span><span onclick="supprimerSalle('+result.data[i].id+')"  class="w3-button w3-transparent "><img class="w3-image" src="/delete.png" /></span></div>';
                }
                /*]]>*/
                $("#salleListView").html(html);
                
                $("#modifierSalleButton").prop("disabled", false);
                $("#hideUpdateButton").click();
            }

        }
        
    });
    
}

function addSalle(){
    var addSaleRequestParam = {};

    //preparer le contenu de la requete
    addSaleRequestParam["nomSalle"] = $("#nomSalleAdd").val();
    addSaleRequestParam["capacite"] = $("#capaciteSalleAdd").val();
    
    $("#addSalleButton").prop("disabled", true);
    
    $.ajax({
        //preparé la requete de type Post comme dans le controlleur dans le serveur
        type: "POST",
        // specifier qu on va communiquer avec du json
        contentType: "application/json",
        // specifier l addresse du controlleur
        url: "/salles",
        //transformer le contenu depuis le tableau en haut a un document json
        data: JSON.stringify(addSaleRequestParam),
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
                var html = '<input placeholder='+quote+'rechercher'+quote+' class='+quote+' w3-input '+quote+' id='+quote+'searchSalleValue'+quote+' onkeyup='+quote+'searchSalle()'+quote+' />';
                for (var i = 0; i < result.data.length; i++) { // pour chaque salle dans la reponse on va ajouter un element a la liste qui a comme methode reserver avec le id de la salle
                    html +=  '<li class='+quote+'w3-display-container'+quote+' > &nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src="/salle.png" />&nbsp;&nbsp;&nbsp;'+result.data[i].nomSalle+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img class='+quote+'w3-image'+quote+' src='+quote+'/chaise.png'+quote+' />'+result.data[i].capacite+'<div class='+quote+'w3-display-right'+quote+'> <span onclick="modifierSalle('+result.data[i].nomSalle+','+result.data[i].capacite+','+result.data[i].id+')" class=" w3-button w3-transparent "> <img class="w3-image" src="/edit.png" /></span><span onclick="supprimerSalle('+result.data[i].id+')"  class="w3-button w3-transparent "><img class="w3-image" src="/delete.png" /></span></div>';
                }
                /*]]>*/
                $("#salleListView").html(html);
                $("#addSalleButton").prop("disabled", false);
                
            }
        }
    });

    
}

function searchSalle() {
    var input, filter, ul, li, a, i;
    input = document.getElementById("searchSalleValue");
    filter = input.value;
    ul = document.getElementById("salleListView");
    li = ul.getElementsByTagName("li");
    for (i = 0; i < li.length; i++) {
        a = li[i].innerHTML;
       // alert(a);
        if (a.indexOf(filter) > -1) {
            li[i].style.display = "";
        } else {
            li[i].style.display = "none";

        }
    }
}




function modifierSalle(nomSalle,capacite,id){
        
       
        
        $('#idSalle').val(id);
        $('#nomSalle').val(nomSalle);
        $('#capacite').val(capacite);
        
        document.getElementById('updateSalleForm').style.display = 'block';
        
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
