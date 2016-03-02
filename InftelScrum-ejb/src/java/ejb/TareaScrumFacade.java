/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.TareaScrum;

/**
 *
 * @author inftel20
 */
@Stateless
public class TareaScrumFacade extends AbstractFacade<TareaScrum> {
    @PersistenceContext(unitName = "InftelScrum-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TareaScrumFacade() {
        super(TareaScrum.class);
    }
    
}
