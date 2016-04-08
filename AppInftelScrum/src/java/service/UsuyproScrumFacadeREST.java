/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;


import ejb.UsuarioScrumFacade;
import ejb.UsuyproScrumFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.ProyectoScrum;
import model.UsuarioScrum;
import model.UsuyproScrum;

/**
 *
 * @author inftel20
 */
@Stateless
@Path("entity.usuyproscrum")
public class UsuyproScrumFacadeREST  {
    @EJB
    private UsuarioScrumFacade usuarioScrumFacade;
    @EJB
    private UsuyproScrumFacade usuyproScrumFacade;
    

    public UsuyproScrumFacadeREST() {
       
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(UsuyproScrum entity) {
        usuyproScrumFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, UsuyproScrum entity) {
        usuyproScrumFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        usuyproScrumFacade.remove(usuyproScrumFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public UsuyproScrum find(@PathParam("id") Long id) {
        return usuyproScrumFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<UsuyproScrum> findAll() {
        return usuyproScrumFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<UsuyproScrum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return usuyproScrumFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(usuyproScrumFacade.count());
    }
    
    @GET
    @Path("projects/{email}")
    @Produces({"application/xml", "application/json"})
    public List<ProyectoScrum> findAllProjectById(@PathParam("email") String email){
        List <UsuarioScrum> users = usuarioScrumFacade.findByEmail(email);
        UsuarioScrum us = users.get(0);
        return usuyproScrumFacade.findAllProjectById(us.getIdUsuario());
    }
    
}
