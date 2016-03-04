/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.UsuarioScrum;

/**
 *
 * @author inftel20
 */
@Stateless
public class UsuarioScrumFacade extends AbstractFacade<UsuarioScrum> {
    @PersistenceContext(unitName = "InftelScrum-ejbPU")
    public EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioScrumFacade() {
        super(UsuarioScrum.class);
    }
    public List <UsuarioScrum> findByEmail (String email){
        List <UsuarioScrum> resultList = getEntityManager().createQuery("SELECT p FROM UsuarioScrum p WHERE p.email LIKE :email").setParameter("email", email).getResultList();
        return resultList;
    }
    
    public List <String> findEmails (){
        List <String> resultList = getEntityManager().createQuery("SELECT p.email FROM UsuarioScrum p ").getResultList();
        return resultList;
    }
    
}
