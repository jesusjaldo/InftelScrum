/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExampleBeans;

/**
 *
 * @author aitorpagan
 */
public class ProjectModelExample {
    
    private String project_Name;
    private String description;
    private int id_Project;
    
    public ProjectModelExample(){}

    public ProjectModelExample(String project_Name, String description, int id_Project) {
        this.project_Name = project_Name;
        this.description = description;
        this.id_Project = id_Project;
    }
    
    

    public String getProject_Name() {
        return project_Name;
    }

    public void setProject_Name(String project_Name) {
        this.project_Name = project_Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_Project() {
        return id_Project;
    }

    public void setId_Project(int id_Project) {
        this.id_Project = id_Project;
    }
    
    
    
}
