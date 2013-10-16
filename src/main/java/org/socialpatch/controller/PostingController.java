/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.socialpatch.entities.Post;
import org.socialpatch.entities.PostAccess;
import org.socialpatch.facade.PostFacade;
import org.socialpatch.utils.UserProperties;

/**
 *
 * @author sprucewerk
 */
@Stateless
public class PostingController {

    @EJB
    private PostFacade postFacade;

    public void addPost(Post post) {

        postFacade.create(post);

    }

    public List<Post> getPostFor(String personId, int start, int end) {

        return postFacade.findRange(new int[]{start, end});
    }

    public List<Post> getPosts(UserProperties userProperties) {

        return getPostsProgrammaticWay(userProperties);

    }

    //really bad approach for testing purposes
    private List<Post> getPostsProgrammaticWay(UserProperties userProperties) {

        List<String> groupIds = userProperties.getGroupIds();
        String userId = userProperties.getUserId();

        System.out.println("getPostsProgrammaticWay - groupIds="+groupIds+" userId="+userId);
        
        List<Post> filteredPosts = new ArrayList<Post>();

        List<Post> allPosts = postFacade.findAll();

        for (Post post : allPosts) {
            List<PostAccess> postAccessList = post.getPostAccessList();

            //1. no access restriction            
            if (postAccessList.isEmpty()) {
                filteredPosts.add(post);
                continue;
            }


            //2. directed to the user or the user group
            for (PostAccess postAccess : postAccessList) {
                String personId = postAccess.getPersonId();

                System.out.println("post access personId = "+personId);
                
                if (userId != null && userId.equalsIgnoreCase(personId)) {
                    filteredPosts.add(post);//directed to user
                    break;
                }

                if(postAccess.getGroupId()!=null 
                        && groupIds != null 
                        && groupIds.contains(postAccess.getGroupId())){
                    filteredPosts.add(post);//directed to group
                    break;                                        
                }
                
            }

        }


        return filteredPosts;
    }
}
