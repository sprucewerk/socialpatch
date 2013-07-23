/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.socialpatch.entities.Post;
import org.socialpatch.facade.PostFacade;

/**
 *
 * @author sprucewerk
 */
@Stateless
public class PostingController {

    @EJB
    private PostFacade postFacade;
    
    public void addPost(Post post){
        
        postFacade.create(post);
        
    }
    
    
    public List<Post> getPostFor(String personId,int start,int end){
        
        return postFacade.findRange(new int[]{start,end});
    }
    
    
}
