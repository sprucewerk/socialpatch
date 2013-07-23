/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sprucewerk
 */
@Entity
@Table(name = "post_access")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PostAccess.findAll", query = "SELECT p FROM PostAccess p"),
    @NamedQuery(name = "PostAccess.findById", query = "SELECT p FROM PostAccess p WHERE p.id = :id"),
    @NamedQuery(name = "PostAccess.findByCreatedAt", query = "SELECT p FROM PostAccess p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PostAccess.findByPersonId", query = "SELECT p FROM PostAccess p WHERE p.personId = :personId"),
    @NamedQuery(name = "PostAccess.findByGroupId", query = "SELECT p FROM PostAccess p WHERE p.groupId = :groupId")})
public class PostAccess implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "person_id")
    private String personId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "group_id")
    private String groupId;
    @JoinColumn(name = "post_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Post post;

    public PostAccess() {
    }

    public PostAccess(Long id) {
        this.id = id;
    }

    public PostAccess(Long id, Date createdAt, String personId, String groupId) {
        this.id = id;
        this.createdAt = createdAt;
        this.personId = personId;
        this.groupId = groupId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PostAccess)) {
            return false;
        }
        PostAccess other = (PostAccess) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialpatch.entities.PostAccess[ id=" + id + " ]";
    }
    
}
