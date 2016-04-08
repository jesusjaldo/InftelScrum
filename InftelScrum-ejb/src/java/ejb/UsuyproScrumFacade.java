/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.math.BigDecimal;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.ProyectoScrum;
import model.UsuarioScrum;
import model.UsuyproScrum;

/**
 *
 * @author inftel20
 */
@Stateless
public class UsuyproScrumFacade extends AbstractFacade<UsuyproScrum> {
    @PersistenceContext(unitName = "InftelScrum-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuyproScrumFacade() {
        super(UsuyproScrum.class);
    }
    
    public List <UsuyproScrum> getProjectFromUSerAndProject (ProyectoScrum project, UsuarioScrum user){
       
       return (List <UsuyproScrum>) getEntityManager().createNamedQuery("UsuyproScrum.findByIdUsuyIdPro").setParameter("idProyecto", project).setParameter("idUsuario", user).getResultList();
          
    }
    
    public List<ProyectoScrum> findAllProjectById(Long id){
        List<ProyectoScrum> resultList = getEntityManager().createQuery("SELECT u From UsuyProScrum u WHERE u.idUsuario.idUsuario =: id").setParameter("id", id).getResultList();
        return resultList;
    }
}
