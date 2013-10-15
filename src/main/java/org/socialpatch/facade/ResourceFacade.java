/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.facade;

import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import org.socialpatch.entities.Resource;

/**
 *
 * @author vitalifichtner
 */
@Stateless
public class ResourceFacade extends AbstractFacade<Resource> {

    @PersistenceContext(unitName = "socialpatchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ResourceFacade() {
        super(Resource.class);
    }

    public Resource findByUri(String uri) {

        try {

            Query query = em.createNamedQuery("Resource.findByUri");
            query.setParameter("uri", uri);
            return (Resource) query.getSingleResult();

        } catch (Exception ex) {
            return null;
        }
    }

    public Resource createByUri(String uri) {

        Resource resource = new Resource();
        resource.setUri(uri);
        resource.setCreatedAt(new Date());
        
        em.persist(resource);
         
        return resource;
    }
}
