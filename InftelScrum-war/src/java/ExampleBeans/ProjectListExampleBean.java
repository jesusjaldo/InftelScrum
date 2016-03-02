/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleBeans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author aitorpagan
 */
@ManagedBean
@RequestScoped
public class ProjectListExampleBean {
    
    ArrayList<ProjectModelExample> projectList;

    /**
     * Creates a new instance of ProjectListExampleBean
     */
    
    @PostConstruct
    public void init(){
        projectList = new ArrayList<ProjectModelExample>();
        
        ProjectModelExample p1 = new ProjectModelExample("Proyecto 1", "Este proyecto está dedicado para ser un ejemplo numero 1", 1);
        ProjectModelExample p2 = new ProjectModelExample("Proyecto 2", "Este proyecto está dedicado para ser un ejemplo numero 2", 2);
        ProjectModelExample p3 = new ProjectModelExample("Proyecto 3", "Este proyecto está dedicado para ser un ejemplo numero 3", 3);
        
        projectList.add(p1);
        projectList.add(p2);
        projectList.add(p3);
        
    }
    
    public ProjectListExampleBean() {
    }

    public ArrayList<ProjectModelExample> getProjectList() {
        return projectList;
    }

    public void setProjectList(ArrayList<ProjectModelExample> projectList) {
        this.projectList = projectList;
    }
    
    
    
}
