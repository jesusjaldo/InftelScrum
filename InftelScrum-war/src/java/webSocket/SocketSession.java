/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webSocket;

import javax.websocket.Session;

/**
 *
 * @author aitorpagan
 */
public class SocketSession {
    
    private String idproject;
    private Session session;

    public String getIdproject() {
        return idproject;
    }

    public void setIdproject(String idproject) {
        this.idproject = idproject;
    }


    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
    
    
}
