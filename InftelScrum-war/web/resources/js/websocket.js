/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

window.onload = init;
var socket = new WebSocket("ws://localhost:8080/InftelScrum-war/actions/" + document.getElementById("projectid").innerHTML);
socket.onmessage = onMessage;
var premessage = "<li class=\"right clearfix\"><span class=\"chat-img pull-right\"> </span> <div class=\"chat-body clearfix\"> <div class=\"header\"> <small class=\" text-muted\"><span class=\"glyphicon glyphicon-time\"></span>15 mins ago</small> <strong class=\"pull-right primary-font\">Nuevos Mensajes</strong> </div> <p>";
var postmessage = "</p> </div> </li>";
function onMessage(event) {
    var mes = JSON.parse(event.data);
    $("#newmessage").append(premessage + mes.nombre + mes.mensaje + postmessage);
}

function sendMessage(){
    var myjsonmessage = {
        
        nombre: document.getElementById("userName").innerHTML,
        mensaje: document.getElementById("btn-input").value
        
    };
    
    socket.send(JSON.stringify(myjsonmessage));

}

function init(){
    
}

