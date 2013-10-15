/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.api;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.RollbackException;
import javax.validation.ConstraintViolationException;
import org.socialpatch.controller.CommentingController;
import org.socialpatch.entities.Comment;
import org.socialpatch.entities.Resource;
import org.socialpatch.facade.ResourceFacade;

/**
 *
 * @author vitalifichtner
 */
@WebService(serviceName = "CommentingService")
public class CommentingService {

    @EJB
    private CommentingController commentingController;
    
    
    
    public void addComment(String uri, Comment comment){
        
        commentingController.addComment(uri, comment);
        
    }
    
    public void updateComment(Comment comment){
        
    }
    
    public void removeComment(Long id){
        
    }
    
    public List<Comment> getComments(String uri){
        
        return commentingController.getAllCommentsByResourceUri(uri);
    }
    
    
    
    
    public void commentTest(){
        
        Comment comment = new Comment();
        comment.setAuthorId("vitali");
        comment.setCreatedAt(new Date());
        comment.setContent("schleicher!!!");
         
        commentingController.addComment("walking dead", comment);   
        
    }
    
    
}
