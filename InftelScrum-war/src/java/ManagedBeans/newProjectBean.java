/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import ejb.ProyectoScrumFacade;
import ejb.UsuarioScrumFacade;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.ProyectoScrum;

/**
 *
 * @author loubna
 */
@ManagedBean
@RequestScoped
public class newProjectBean {
    
    @ManagedProperty(value = "#{loginBean}")
    protected LoginBean loginBean;
    
    @EJB
    private ProyectoScrumFacade proyectoScrumFacade;
    

   
    protected String titulo;
    protected String descripcion;
    protected ProyectoScrum proyecto;
    
    @PostConstruct
    public void init () {
      proyecto = new ProyectoScrum();
      
    }

    public String doCrearProyecto(){
        this.proyecto.setIdAdmin(loginBean.user);
        this.proyecto.setNombre(titulo);
        this.proyecto.setDescripcion(descripcion);
        Calendar fechaInicio = Calendar.getInstance();
        this.proyecto.setFechaInicio(fechaInicio.getTime());
        ProyectoScrum p=proyecto;
        this.proyectoScrumFacade.create(proyecto);
        loginBean.user.getProyectoScrumCollection().add(p);
        
        return "myProjects";
     
    }

    public ProyectoScrum getProyecto() {
        return proyecto;
    }

    public void setProyecto(ProyectoScrum proyecto) {
        this.proyecto = proyecto;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
   
    
    
}
