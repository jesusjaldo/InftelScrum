/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.ProyectoScrum;

/**
 *
 * @author aitorpagan
 */
@ManagedBean
@RequestScoped
public class MyProjectsBean {

    @ManagedProperty(value = "#{loginBean}")
    protected LoginBean loginBean;
    
    String selectedProject;
    
    Collection projectList;
    /**
     * Creates a new instance of MyProjectsBean
     */
    
    public MyProjectsBean() {
    }
    
    @PostConstruct
    public void init(){        
        projectList = loginBean.getUser().getProyectoScrumCollection();
    }
    
    /*Getters & Setters*/

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Collection<ProyectoScrum> getProjectList() {
        return projectList;
        
    }

    public String getSelectedProject() {
        return selectedProject;
    }

    public void setSelectedProject(String selectedProject) {
        this.selectedProject = selectedProject;
    }
    

    public void setProjectList(Collection<ProyectoScrum> projectList) {
        this.projectList = projectList;
    }
    
    public String goToProject(ProyectoScrum projectId){
        
        System.out.println("Proyecto: " + projectId.getIdProyecto());
        loginBean.selectedProject = projectId;
        return "profile";
    }
    
}
