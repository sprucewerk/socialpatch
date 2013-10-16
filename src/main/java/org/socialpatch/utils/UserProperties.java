/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.utils;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author sprucewerk
 */
public class UserProperties implements Serializable{
    
    private String userId;
    private List<String> groupIds;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds(List<String> groupIds) {
        this.groupIds = groupIds;
    }
    
    
    
}
