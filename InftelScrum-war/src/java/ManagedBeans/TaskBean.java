/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import com.google.gson.Gson;
import ejb.FicherosScrumFacade;
import ejb.ProyectoScrumFacade;
import ejb.TareaScrumFacade;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.FicherosScrum;
import model.ProyectoScrum;
import model.TareaScrum;
import org.apache.commons.io.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author RMA
 */
@ManagedBean
@RequestScoped
public class TaskBean {

    @EJB
    private ProyectoScrumFacade proyectoScrumFacade;

    @EJB
    private FicherosScrumFacade ficherosScrumFacade;

    @EJB
    private TareaScrumFacade tareaScrumFacade;

    @ManagedProperty(value = "#{loginBean}")
    protected LoginBean loginBean;

    protected String titulo;
    protected String descripcion;
    protected String estadoSeleccionado;
    protected Date tiempo;
    protected UploadedFile file;
    protected Status[] estados;

    /**
     * Creates a new instance of TaskBean
     */
    public TaskBean() {

    }

    @PostConstruct
    public void init() {

        /*        BufferedReader br = null;
         try {
         br = new BufferedReader(new FileReader("C:\\Users\\RMA\\Documents\\NetBeansProjects\\InftelScrum\\InftelScrum-war\\web\\resources\\json\\data.json"));
         } catch (FileNotFoundException ex) {
         Logger.getLogger(TaskBean.class.getName()).log(Level.SEVERE, null, ex);
         }
         Gson r = new Gson();
         Estados[] fromJson = r.fromJson(br, Estados[].class);
         estados = fromJson;*/
        ProyectoScrum selectedProject = loginBean.getSelectedProject();
        byte[] estadoPro = selectedProject.getEstados();
        if (estadoPro != null) {
            try {
                InputStream input = new ByteArrayInputStream(estadoPro);
                Gson g = new Gson();
                BufferedReader b;
                b = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                Status[] fromJson = g.fromJson(b, Status[].class);
                estados = fromJson;
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(TaskBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

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

    public String getEstadoSeleccionado() {
        return estadoSeleccionado;
    }

    public void setEstadoSeleccionado(String estadoSeleccionado) {
        this.estadoSeleccionado = estadoSeleccionado;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Status[] getEstados() {
        return estados;
    }

    public void setEstados(Status[] eestados) {
        this.estados = eestados;
    }

    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public String login() throws IOException {

        TareaScrum t = new TareaScrum();
        FicherosScrum fichero = new FicherosScrum();
        TareaScrum editTarea = null;

        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message;
        boolean loggedIn = true;

        Timestamp insertarTiempo;
        insertarTiempo = new Timestamp(tiempo.getTime());

        t.setNombre(titulo);
        t.setDescripcion(descripcion);
        t.setEstado(estadoSeleccionado);
        t.setIdUsuario(loginBean.user);
        t.setIdProyecto(loginBean.selectedProject);
        t.setTiempoEstimado(insertarTiempo);
        Calendar cal = Calendar.getInstance();
        t.setFechaIni(cal.getTime());

        if (!file.getFileName().equals("")) {

            byte[] bytes = IOUtils.toByteArray(file.getInputstream());

            fichero.setFichero(bytes);
            fichero.setExt(file.getFileName());

            ficherosScrumFacade.create(fichero);

            t.setIdFichero(fichero);
        }

        tareaScrumFacade.create(t);

        message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tarea", "La tarea se ha creado correctamente");
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);

        loginBean.selectedProject.getTareaScrumCollection().add(t);
        proyectoScrumFacade.edit(loginBean.selectedProject);

        return "manageProject";

    }

    public String editar(TareaScrum tarea) throws IOException {
        FicherosScrum fichero = new FicherosScrum();
        TareaScrum tareaModificada = new TareaScrum();
        if (file != null) {
            if (!file.getFileName().equals("")) {
                byte[] bytes = IOUtils.toByteArray(file.getInputstream());

                fichero.setFichero(bytes);
                fichero.setExt(file.getFileName());

                ficherosScrumFacade.create(fichero);

                tareaModificada.setIdFichero(fichero);
            }
        }

        tareaModificada.setNombre(titulo);
        tareaModificada.setDescripcion(descripcion);
        tareaModificada.setTiempoEstimado(tiempo);
        tareaModificada.setEstado(estadoSeleccionado);
        tareaModificada.setIdUsuario(loginBean.user);
        tareaModificada.setIdTarea(tarea.getIdTarea());
        tareaModificada.setIdProyecto(loginBean.selectedProject);
        tareaModificada.setFechaIni(tarea.getFechaIni());
        tareaModificada.setFechaFin(tarea.getFechaFin());
        
        Collection<TareaScrum> tareaScrumCollection = loginBean.selectedProject.getTareaScrumCollection();
        for (TareaScrum t : tareaScrumCollection) {
            if (Objects.equals(t.getIdTarea(), tarea.getIdTarea())) {
                tareaScrumCollection.remove(t);
                tareaScrumCollection.add(tareaModificada);
                proyectoScrumFacade.edit(loginBean.selectedProject);
                tareaScrumFacade.edit(tareaModificada);
            }
        }
        return "manageProject"; 
    }

}
