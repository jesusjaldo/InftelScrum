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
import model.TareaScrum;
 
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
 
@ManagedBean
@ViewScoped
public class DashboardView implements Serializable {
     
    @ManagedProperty (value = "#{manageProjectBean}")
    private ManageProjectBean manageProjectBean;
   
    private DashboardModel model;
    private int nstatus;
    
    ArrayList<DefaultDashboardColumn> columns;
    ArrayList<Status> status;
     
    @PostConstruct
    public void init() {
        
       
        model = new DefaultDashboardModel();
        columns = new ArrayList<DefaultDashboardColumn>();
        
        for(int i=0; i<manageProjectBean.getStatus().size(); i++){
            columns.add(new DefaultDashboardColumn());
        }         
        
        for(TareaScrum t: manageProjectBean.getTask_list()){  //Add task to column          
            columns.get(0).addWidget(t.getNombre());   
        }
             
        for(int i=0; i<manageProjectBean.getStatus().size(); i++){ //Add columns to model
            model.addColumn(columns.get(i));
        }    
    }

    public ManageProjectBean getManageProjectBean() {
        return manageProjectBean;
    }

    public void setManageProjectBean(ManageProjectBean manageProjectBean) {
        this.manageProjectBean = manageProjectBean;
    }

    public int getNstatus() {
        return nstatus;
    }

    public void setNstatus(int nstatus) {
        this.nstatus = nstatus;
    }

    public ArrayList<Status> getStatus() {
        return status;
    }

    public void setStatus(ArrayList<Status> status) {
        this.status = status;
    }

    public ManageProjectBean getProjectBean() {
        return manageProjectBean;
    }

    public void setProjectBean(ManageProjectBean projectBean) {
        this.manageProjectBean = projectBean;
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
        message.setSummary("Cambio de estado: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());
        
        addMessage(message);
    }
     
    public void addStatus(){     
        
     model.addColumn(new DefaultDashboardColumn());
        
    }
    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");
        //DELETE TASK
        manageProjectBean.deleteTask(event.getComponent().getId());
        addMessage(message);
    }
     
    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());
        //CHANGE TASK STATUS
        manageProjectBean.setTaskStatus(event.getComponent().getId(), event.getVisibility().name());
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public DashboardModel getModel() {
        return model;
    }  
    
}