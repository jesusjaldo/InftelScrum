/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.FicherosScrumFacade;

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
import model.FicherosScrum;

/**
 *
 * @author inftel20
 */
@Stateless
@Path("entity.ficherosscrum")
public class FicherosScrumFacadeREST {
    @EJB
    private FicherosScrumFacade ficherosScrumFacade;
    @PersistenceContext(unitName = "AppInftelScrumPU")
    private EntityManager em;
    
    

    public FicherosScrumFacadeREST() {
      
    }

    @POST
    @Consumes({"application/xml", "application/json"})
    public void create(FicherosScrum entity) {
        ficherosScrumFacade.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, FicherosScrum entity) {
        ficherosScrumFacade.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        ficherosScrumFacade.remove(ficherosScrumFacade.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public FicherosScrum find(@PathParam("id") Long id) {
        return ficherosScrumFacade.find(ficherosScrumFacade.find(id));
        
    }

    @GET

    @Produces({"application/xml", "application/json"})
    public List<FicherosScrum> findAll() {
       
        return ficherosScrumFacade.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<FicherosScrum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
       
        return ficherosScrumFacade.findRange(new int []{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        
        return String.valueOf(ficherosScrumFacade.count());
                
    }

  
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
