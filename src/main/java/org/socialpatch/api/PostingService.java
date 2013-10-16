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
import org.socialpatch.controller.PostingController;
import org.socialpatch.entities.Post;
import org.socialpatch.utils.UserProperties;

/**
 *
 * @author sprucewerk
 */
@WebService(serviceName = "PostingService")
public class PostingService {

    @EJB
    private PostingController postingController;
    
    public void addPost(Post post){
        postingController.addPost(post);
    }
    
    
    public List<Post> getPostFor(String personId,int start,int end){
        return postingController.getPostFor(personId, start, end);
    }
 
    
    public List<Post> getPosts(UserProperties userProperties){
        return postingController.getPosts(userProperties);
    }
    
 
    
}
