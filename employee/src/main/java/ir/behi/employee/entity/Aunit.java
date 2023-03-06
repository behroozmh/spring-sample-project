/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.behi.employee.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * create User: behrooz.mh
 * Date: 3/5/2023
 * TIME: 1:24 PM
 **/
@Entity
@Table(name = "aunit", catalog = "easy", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aunit.findAll", query = "SELECT a FROM Aunit a"),
    @NamedQuery(name = "Aunit.findById", query = "SELECT a FROM Aunit a WHERE a.id = :id"),
    @NamedQuery(name = "Aunit.findByName", query = "SELECT a FROM Aunit a WHERE a.name = :name"),
    @NamedQuery(name = "Aunit.findByComment", query = "SELECT a FROM Aunit a WHERE a.comment = :comment"),
    @NamedQuery(name = "Aunit.findByStatus", query = "SELECT a FROM Aunit a WHERE a.status = :status")})
public class Aunit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Muser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unitId", fetch = FetchType.LAZY)
    private List<Arepository> arepositoryList;

    public Aunit() {
    }

    public Aunit(Integer id) {
        this.id = id;
    }

    public Aunit(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Muser getUserId() {
        return userId;
    }

    public void setUserId(Muser userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Arepository> getArepositoryList() {
        return arepositoryList;
    }

    public void setArepositoryList(List<Arepository> arepositoryList) {
        this.arepositoryList = arepositoryList;
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
        if (!(object instanceof Aunit)) {
            return false;
        }
        Aunit other = (Aunit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Aunit[ id=" + id + " ]";
    }
    
}
