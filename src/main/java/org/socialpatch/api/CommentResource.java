/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.api;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.DELETE;
import org.socialpatch.controller.CommentingController;
import org.socialpatch.entities.Comment;

/**
 * REST Web Service
 *
 * @author sprucewerk
 */
@Path("comment")
@RequestScoped
public class CommentResource {


    @EJB
    private CommentingController commentingController;
    
    
    
    @PUT
    @Consumes({"*/*", "application/json"})
    @Path("/{uri}/post/{postId}")
    public void addPostComment(@PathParam("postId")Long postId,@PathParam("uri") String uri, Comment comment){
        
        commentingController.addPostComment(postId,uri, comment);
        
    }
    
    
    @PUT
    @Consumes({"*/*", "application/json"})
    @Path("/{uri}")
    public void addComment(@PathParam("uri")String uri, Comment comment){
        commentingController.addComment(uri, comment);        
    }
    
    @PUT
    @Consumes({"*/*", "application/json"})
    public void updateComment(Comment comment){
        commentingController.updateComment(comment);
    }
    
    @DELETE
    @Path("/{id}")
    public void removeCommentById(@PathParam("id")Long id){
        commentingController.removeCommentById(id);
    }
    
    
    @GET
    @Produces("application/json")
    @Path("/{uri}")
    public List<Comment> getCommentsByUri(@PathParam("uri")String uri){
        
        return commentingController.getAllCommentsByResourceUri(uri);
    }
    
    @GET
    @Produces("application/json")
    @Path("/first/{uri}")
    public Comment getFirstCommentByUri(@PathParam("uri")String uri){
        
        return commentingController.getAllCommentsByResourceUri(uri).get(0);
    }
    
    
    
    
    /**
     * Creates a new instance of CommentResource
     */
    public CommentResource() {
    }

   
    
    
}
