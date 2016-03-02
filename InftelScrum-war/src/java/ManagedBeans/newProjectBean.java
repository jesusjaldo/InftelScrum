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
import javax.faces.bean.SessionScoped;
import model.ProyectoScrum;
import model.UsuarioScrum;

/**
 *
 * @author loubna
 */
@ManagedBean
@SessionScoped
public class newProjectBean {

    @EJB
    private UsuarioScrumFacade usuarioScrumFacade;

    @EJB
    private ProyectoScrumFacade proyectoScrumFacade;
    
  // @ManagedProperty(value="#{loginBean}")
   // private LoginBean loginBean;

    protected String titulo;
    protected String descripcion;
    protected ProyectoScrum proyecto;
    
        @PostConstruct
    public void init () {
      proyecto = new ProyectoScrum();
      
    }

    public void doCrearProyecto(){
        UsuarioScrum find = usuarioScrumFacade.find(Long.valueOf("1"));
        this.proyecto.setIdAdmin(find);
        this.proyecto.setNombre(titulo);
        this.proyecto.setDescripcion(descripcion);
        Calendar fechaInicio = Calendar.getInstance();
        this.proyecto.setFechaInicio(fechaInicio.getTime());
        ProyectoScrum p=proyecto;
        this.proyectoScrumFacade.create(proyecto);
    
     
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
   
    
}
