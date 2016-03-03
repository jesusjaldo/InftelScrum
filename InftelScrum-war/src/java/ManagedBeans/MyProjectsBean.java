/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ejb.ProyectoScrumFacade;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.ProyectoScrum;

/**
 *
 * @author aitorpagan
 */
@Named(value = "myProjectsBean")
@RequestScoped
public class MyProjectsBean {
    
    @EJB
    private ProyectoScrumFacade proyectoScrumFacade;
    

    @ManagedProperty(value="#{loginBean}")
    private LoginBean loginBean;
    
    ArrayList<ProyectoScrum> projectList;
    /**
     * Creates a new instance of MyProjectsBean
     */
    
    @PostConstruct
    public void init(){
        projectList = new ArrayList<ProyectoScrum>();
    }
    
    
    public MyProjectsBean() {
    }
    
    /*Getters & Setters*/

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public ArrayList<ProyectoScrum> getProjectList() {
        return projectList;
    }

    public void setProjectList(ArrayList<ProyectoScrum> projectList) {
        this.projectList = projectList;
    }
    
    
    
}
