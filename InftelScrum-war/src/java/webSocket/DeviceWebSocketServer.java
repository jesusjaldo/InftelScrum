/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webSocket;

import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
//import javax.faces.bean.ApplicationScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.server.PathParam;

@ApplicationScoped
@ServerEndpoint("/actions/{idproject}")
public class DeviceWebSocketServer {
    
    @Inject
    private DeviceSessionHandler sessionHandler;
    
    @PostConstruct
    public void afterCreate() {
        System.out.println("DeviceWebSocketServer created");
    }    

    @OnOpen
        public void open(@PathParam("idproject") String projectId, Session session) {
            sessionHandler.addSocketSession(projectId, session);
    }

    @OnClose
        public void close(@PathParam("idproject") String projectId, Session session) {
            sessionHandler.removeSocketSession(projectId, session);
    }

    @OnError
        public void onError(Throwable error) {
            Logger.getLogger(DeviceWebSocketServer.class.getName()).log(Level.SEVERE, null, error);
    }

    @OnMessage
        public void handleMessage(@PathParam("idproject") String projectId, String message, Session session) {
            
            JsonReader reader = Json.createReader(new StringReader(message));
            JsonObject jsonMessage = reader.readObject();
            
            sessionHandler.sendToAllProjectSessions(projectId, jsonMessage);
            
            
        }
}    
