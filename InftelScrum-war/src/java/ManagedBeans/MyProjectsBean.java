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

    public void setProjectList(Collection<ProyectoScrum> projectList) {
        this.projectList = projectList;
    }
    
    
    
}
