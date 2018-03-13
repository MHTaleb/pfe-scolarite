/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function () {

    $("#send_mail").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_send_mail();

    });

});

function fire_send_mail(){
    
        
    var contactMail = {};
    
    contactMail["nom"]=$("#nom").val();
    contactMail["prenom"]=$("#prenom").val();
    contactMail["message"]=$("#message").val();
    
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/homePage/contact",
        data: JSON.stringify(contactMail),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        error: function (e) {
            alert("Message envoyer");

        }
    });

    
}