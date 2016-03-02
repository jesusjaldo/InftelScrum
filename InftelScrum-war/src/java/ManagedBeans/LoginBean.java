/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ejb.UsuarioScrumFacade;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.UsuarioScrum;

/**
 *
 * @author inftel20
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    @EJB
    private UsuarioScrumFacade usuarioScrumFacade;

    protected boolean logueado;
    protected UsuarioScrum user;
    protected String image;
    
    
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    @PostConstruct
    public void init(){
        this.user = usuarioScrumFacade.find(1);
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public UsuarioScrum getUser() {
        return user;
    }

    public void setUser(UsuarioScrum user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
