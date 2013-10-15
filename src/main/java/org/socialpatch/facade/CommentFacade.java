/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.socialpatch.entities.Comment;

/**
 *
 * @author vitalifichtner
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "socialpatchPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
}
