/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;

import ejb.UsuarioScrumFacade;
import ejb.UsuyproScrumFacade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import model.ProyectoScrum;
import model.UsuarioScrum;
import model.UsuyproScrum;

/**
 *
 * @author aitorpagan
 */
@ManagedBean
@RequestScoped
public class MyProjectsBean {

    @EJB
    private UsuyproScrumFacade usuyproScrumFacade;
    @EJB
    private UsuarioScrumFacade usuarioScrumFacade;

    @ManagedProperty(value = "#{loginBean}")
    protected LoginBean loginBean;

    Collection<UsuyproScrum> usuyproScrumCollection;

    protected String invitacion;
    protected String invitar;
    protected List<String> mails;

    /**
     * Creates a new instance of MyProjectsBean
     */

    public MyProjectsBean() {
    }

    @PostConstruct
    public void init() {

        usuyproScrumCollection = loginBean.getUser().getUsuyproScrumCollection();
        mails = usuarioScrumFacade.findEmails();
        invitacion = "";
    }

    /*Getters & Setters*/
    public LoginBean getLoginBean() {
        return loginBean;
    }

    public void setLoginBean(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public Collection<UsuyproScrum> getUsuyproScrumCollection() {
        return usuyproScrumCollection;
    }

    public void setUsuyproScrumCollection(Collection<UsuyproScrum> usuyproScrumCollection) {
        this.usuyproScrumCollection = usuyproScrumCollection;
    }

    public String getInvitacion() {
        return invitacion;
    }

    public void setInvitacion(String invitacion) {
        this.invitacion = invitacion;
    }

    public String getInvitar() {
        return invitar;
    }

    public void setInvitar(String invitar) {
        this.invitar = invitar;
    }

    public List<String> getMails() {
        return mails;
    }

    public void setMails(List<String> mails) {
        this.mails = mails;
    }

    public List<String> completeMail(String query) {
        List<String> results = new ArrayList<>();
        for (String result : mails) {
            if (result.contains(query)) {
                results.add(result);
            }
        }
        return results;
    }

    public void enviar(ProyectoScrum project) {

        List<UsuarioScrum> usuariosInvitados = usuarioScrumFacade.findByEmail(invitacion);
        UsuyproScrum usuypro = new UsuyproScrum();

        usuypro.setIdProyecto(project);
        usuypro.setIdUsuario(usuariosInvitados.get(0));
        usuyproScrumFacade.create(usuypro);

    }

    public String goToProject(ProyectoScrum projectId) {

        System.out.println("Proyecto: " + projectId.getIdProyecto());
        loginBean.selectedProject = projectId;
        return "profile";
    }

    public String goToEditProject(ProyectoScrum projectId) {

        System.out.println("Proyecto: " + projectId.getIdProyecto());
        loginBean.selectedProject = projectId;
        return "editProject";
    }

}
