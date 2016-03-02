/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ProyectoScrum;

/**
 *
 * @author inftel20
 */
@Stateless
public class ProyectoScrumFacade extends AbstractFacade<ProyectoScrum> {
    @PersistenceContext(unitName = "InftelScrum-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProyectoScrumFacade() {
        super(ProyectoScrum.class);
    }
    
}
