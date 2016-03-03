/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
 
@ManagedBean
@ViewScoped
public class DashboardView implements Serializable {
     
    @ManagedProperty ("#{projectBean}")
    private ProjectBean projectBean;
   
    private DashboardModel model;
       
    ArrayList<DefaultDashboardColumn> columns;
     
    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        columns = new ArrayList<DefaultDashboardColumn>();
        
        for(int i=0; i<projectBean.status.size(); i++){
            columns.add(new DefaultDashboardColumn());
        }         
        
        for(Task t: projectBean.getTask_list()){  //Add task to column          
            columns.get(t.getStatus()).addWidget(t.name);  
        }
             
        for(int i=0; i<projectBean.status.size(); i++){ //Add columns to model
            model.addColumn(columns.get(i));
        }    
    }

    public ProjectBean getProjectBean() {
        return projectBean;
    }

    public void setProjectBean(ProjectBean projectBean) {
        this.projectBean = projectBean;
    }

    public ArrayList<DefaultDashboardColumn> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<DefaultDashboardColumn> columns) {
        this.columns = columns;
    }
     
    
    
    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
      
        addMessage(message);
    }
     
    public void addStatus(){
        projectBean.getStatus().add("New Status");
        model.addColumn(new DefaultDashboardColumn());
        
    }
    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
         //DELETE TASK
        addMessage(message);
    }
     
    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        //CHANGE TASK STATUS
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DashboardModel getModel() {
        return model;
    }  
    
}