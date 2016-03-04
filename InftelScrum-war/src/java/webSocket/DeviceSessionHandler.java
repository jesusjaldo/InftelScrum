/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webSocket;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.spi.JsonProvider;
import javax.websocket.Session;

@ApplicationScoped
public class DeviceSessionHandler {
    private int deviceId = 0;
    private final ArrayList<Session> sessions = new ArrayList<>();
    private final ArrayList<SocketSession> socketSessions = new ArrayList<>();
    
    @PostConstruct
    public void afterCreate() {
        System.out.println("DeviceSessionHandler created");
    }        
    
    public void addSession(Session session) {
        sessions.add(session);
    }
    
    public void addSocketSession(String idProject, Session session) {
        SocketSession ss = new SocketSession();
        ss.setIdproject(idProject);
        ss.setSession(session);
        socketSessions.add(ss);
    }

    public void removeSession(Session session) {
        sessions.remove(session);
    }
    
    public void removeSocketSession(String idProject, Session session){
        SocketSession ss = new SocketSession();
        ss.setIdproject(idProject);
        ss.setSession(session);
        socketSessions.remove(ss);
    }

    protected void sendToAllConnectedSessions(JsonObject message) {
        for (Session session : sessions) {
            sendToSession(session, message);
        }
    }
    
    protected void sendToAllProjectSessions(String idProject, JsonObject message) {
        for (SocketSession ss : socketSessions) {
            if(ss.getIdproject().equalsIgnoreCase(idProject)){
            sendToSession(ss.getSession(), message);               
            }
        }
    }

    private void sendToSession(Session session, JsonObject message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException ex) {
            sessions.remove(session);
            Logger.getLogger(DeviceSessionHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void configureAndSend(JsonObject message){
        JsonProvider provider = JsonProvider.provider();
            JsonObject addMessage = provider.createObjectBuilder()
                .add("nombre", "Pepe")
                .add("mensaje", "Mensaje")
                .build();
        sendToAllConnectedSessions(addMessage);
    }
    
}
