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
@Table(name = "litemtype", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Litemtype.findAll", query = "SELECT l FROM Litemtype l"),
    @NamedQuery(name = "Litemtype.findById", query = "SELECT l FROM Litemtype l WHERE l.id = :id"),
    @NamedQuery(name = "Litemtype.findByComment", query = "SELECT l FROM Litemtype l WHERE l.comment = :comment"),
    @NamedQuery(name = "Litemtype.findByName", query = "SELECT l FROM Litemtype l WHERE l.name = :name"),
    @NamedQuery(name = "Litemtype.findByStatus", query = "SELECT l FROM Litemtype l WHERE l.status = :status")})
public class Litemtype implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Muser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemTypeId", fetch = FetchType.LAZY)
    private List<Litem> litemList;

    public Litemtype() {
    }

    public Litemtype(Integer id) {
        this.id = id;
    }

    public Litemtype(Integer id, String name, String status) {
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    public List<Litem> getLitemList() {
        return litemList;
    }

    public void setLitemList(List<Litem> litemList) {
        this.litemList = litemList;
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
        if (!(object instanceof Litemtype)) {
            return false;
        }
        Litemtype other = (Litemtype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Litemtype[ id=" + id + " ]";
    }
    
}
