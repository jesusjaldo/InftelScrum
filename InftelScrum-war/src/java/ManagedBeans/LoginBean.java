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
import javax.faces.bean.SessionScoped;
import model.UsuarioScrum;

/**
 *
 * @author inftel20
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    @EJB
    private UsuarioScrumFacade usuarioScrumFacade;

    protected boolean sesion;
    protected UsuarioScrum user;
    protected String image;
    
    
    
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    @PostConstruct
    public void init(){
        this.sesion = false;
        this.user = new UsuarioScrum();
        this.user = usuarioScrumFacade.find(Long.valueOf("1"));
    }

    public boolean isSesion() {
        return sesion;
    }

    public void setSesion(boolean sesion) {
        this.sesion = sesion;
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
