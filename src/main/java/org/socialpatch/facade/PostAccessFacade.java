/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.socialpatch.entities.PostAccess;

/**
 *
 * @author sprucewerk
 */
@Stateless
public class PostAccessFacade extends AbstractFacade<PostAccess> {
    @PersistenceContext(unitName = "socialpatchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostAccessFacade() {
        super(PostAccess.class);
    }
    
}
