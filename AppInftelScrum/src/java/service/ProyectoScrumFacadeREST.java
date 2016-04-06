/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.ProyectoScrumFacade;

import java.math.BigDecimal;
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
import model.ProyectoScrum;

/**
 *
 * @author inftel20
 */
@Stateless
@Path("entity.proyectoscrum")
public class ProyectoScrumFacadeREST  {
    @EJB
    private ProyectoScrumFacade proyectoScrumFacade;
    @PersistenceContext(unitName = "AppInftelScrumPU")
    private EntityManager em;
    

    public ProyectoScrumFacadeREST() {
      
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(ProyectoScrum entity) {
        proyectoScrumFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") BigDecimal id, ProyectoScrum entity) {
        proyectoScrumFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        proyectoScrumFacade.remove(proyectoScrumFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public ProyectoScrum find(@PathParam("id") BigDecimal id) {
        return proyectoScrumFacade.find(id);
    }

    @GET
    @Produces({"application/xml", "application/json"})
    public List<ProyectoScrum> findAll() {
        return proyectoScrumFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<ProyectoScrum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return proyectoScrumFacade.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(proyectoScrumFacade.count());
    }


    protected EntityManager getEntityManager() {
        return em;
    }
    
}
