/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.TareaScrumFacade;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import model.TareaScrum;

/**
 *
 * @author inftel20
 */
@Stateless
@Path("entity.tareascrum")
public class TareaScrumFacadeREST  {
    @EJB
    private TareaScrumFacade tareaScrumFacade;
    @PersistenceContext(unitName = "AppInftelScrumPU")
    private EntityManager em;
    

    public TareaScrumFacadeREST() {

    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(TareaScrum entity) {
        tareaScrumFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, TareaScrum entity) {
        tareaScrumFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        tareaScrumFacade.remove(tareaScrumFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TareaScrum find(@PathParam("id") Long id) {
        return tareaScrumFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<TareaScrum> findAll() {
        return tareaScrumFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TareaScrum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return tareaScrumFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(tareaScrumFacade.count());
    }

    protected EntityManager getEntityManager() {
        return em;
    }
    
}
