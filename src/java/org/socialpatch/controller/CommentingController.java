/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.socialpatch.entities.Comment;
import org.socialpatch.entities.Resource;
import org.socialpatch.facade.CommentFacade;
import org.socialpatch.facade.ResourceFacade;

/**
 *
 * @author sprucewerk
 */
@Stateless
public class CommentingController {

    @EJB
    private CommentFacade commentFacade;
    @EJB
    private ResourceFacade resourceFacade;
    
    
    /**
     * Adds comment for a resource.
     * If the resource is not available it will be created.
     * 
     * 
     * @param comment - comment 
     */
    public void addComment(String uri, Comment comment){
        
        Resource resource = resourceFacade.findByUri(uri);
        
        if(resource==null){
            resource = resourceFacade.createByUri(uri);
        }

        comment.setResource(resource);
        resource.getCommentList().add(comment);
        
    }
    
    public List<Comment> getAllCommentsByResourceUri(String uri){
        Resource resource = resourceFacade.findByUri(uri);
        
        if(resource == null) return null;
        
        return resource.getCommentList();
    }

}
