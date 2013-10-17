/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.socialpatch.entities.Comment;
import org.socialpatch.entities.Post;
import org.socialpatch.entities.Resource;
import org.socialpatch.facade.CommentFacade;
import org.socialpatch.facade.PostFacade;
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
    @EJB
    private PostFacade postFacade;
    
    /**
     * Adds comment for a resource.
     * If the resource is not available it will be created.
     * 
     * 
     * @param comment - comment 
     */
    public void addComment(String uri, Comment comment){
        System.out.println("addComment -uri"+uri);
        Resource resource = resourceFacade.findByUri(uri);
        
        if(resource==null){
            resource = resourceFacade.createByUri(uri);
        }

        comment.setResource(resource);
        resource.getCommentList().add(comment);
        
    }
    
    
    
    
    public void addPostComment(Long postId, String uri, Comment comment) {
        System.out.println("addPostComment - postId="+postId);
        Post post = postFacade.find(postId);
        
        Resource resource = resourceFacade.findByUri(uri);
        
        if(resource==null){
            resource = resourceFacade.createByUri(uri);
            post.setResource(resource);
        }

        post.setUpdatedAt(new Date());//refresh post
        comment.setResource(resource);
        resource.getCommentList().add(comment);
        
    }

    
    
    
    
    public List<Comment> getAllCommentsByResourceUri(String uri){
        System.out.println("getAllCommentsByResourceUri - "+uri);
        
        Resource resource = resourceFacade.findByUri(uri);
        
        if(resource == null) return null;
        
        System.out.println("resource.getCommentList() - "+resource.getCommentList());
        return resource.getCommentList();
    }

    public void updateComment(Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void removeCommentById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
