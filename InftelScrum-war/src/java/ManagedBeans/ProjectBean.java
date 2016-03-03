/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author inftel19
 */

@ManagedBean(name = "projectBean")
@SessionScoped
public class ProjectBean {

    private String name_project;
    private ArrayList<Task> task_list; //
    ArrayList<String> status = new ArrayList<String>();

    @PostConstruct
    public void init() {
        task_list = new ArrayList<Task>();
        Task task_a = new Task("login", "hacer login", 0);
        Task task_b = new Task("home", "hacer home", 0);
        Task task_c = new Task("contact", "hacer login", 1);
        Task task_d = new Task("logout", "hacer logout", 2);
        task_list.add(task_a);
        task_list.add(task_b);
        task_list.add(task_c);
        task_list.add(task_d);
        status.add("To do");
        status.add("Doing");
        status.add("Done");

        name_project = "Project";
    }

    public ArrayList<Task> getTask_list() {
        return task_list;
    }

    public void setTask_list(ArrayList<Task> task_list) {
        this.task_list = task_list;
    }  

    public String getName_project() {
        return name_project;
    }

    public void setName_project(String name_project) {
        this.name_project = name_project;
    }

    public ArrayList<String> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<String> status) {
        this.status = status;
    }

  

}
