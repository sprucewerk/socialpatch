/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socialpatch.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author sprucewerk
 */
@Entity
@Table(name = "post")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p"),
    @NamedQuery(name = "Post.findById", query = "SELECT p FROM Post p WHERE p.id = :id"),
    @NamedQuery(name = "Post.findByCreatedAt", query = "SELECT p FROM Post p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Post.findByUpdatedAt", query = "SELECT p FROM Post p WHERE p.updatedAt = :updatedAt"),
    @NamedQuery(name = "Post.findByPersonId", query = "SELECT p FROM Post p WHERE p.personId = :personId"),
    @NamedQuery(name = "Post.findByAuthorName", query = "SELECT p FROM Post p WHERE p.authorName = :authorName"),
    @NamedQuery(name = "Post.findByTitle", query = "SELECT p FROM Post p WHERE p.title = :title")})
public class Post implements Serializable {
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
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "person_id")
    private String personId;
    @Size(max = 255)
    @Column(name = "author_name")
    private String authorName;
    @Basic(optional = true)
    @Size(min = 1, max = 350)
    @Column(name = "title")
    private String title;
    @Basic(optional = true)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "link")
    private String link;
    @Basic(optional = true)
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "img_url")
    private String imgUrl;
    @JoinColumn(name = "resource_id", referencedColumnName = "id")
    @ManyToOne
    private Resource resource;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostAccess> postAccessList;

    public Post() {
    }

    public Post(Long id) {
        this.id = id;
    }

    public Post(Long id, Date createdAt, String personId, String title, String body, String link, String imgUrl) {
        this.id = id;
        this.createdAt = createdAt;
        this.personId = personId;
        this.title = title;
        this.body = body;
        this.link = link;
        this.imgUrl = imgUrl;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @XmlTransient
    public List<PostAccess> getPostAccessList() {
        return postAccessList;
    }

    public void setPostAccessList(List<PostAccess> postAccessList) {
        this.postAccessList = postAccessList;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.socialpatch.entities.Post[ id=" + id + " ]";
    }
    
}
