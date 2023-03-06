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
@Table(name = "arepository", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arepository.findAll", query = "SELECT a FROM Arepository a"),
    @NamedQuery(name = "Arepository.findById", query = "SELECT a FROM Arepository a WHERE a.id = :id"),
    @NamedQuery(name = "Arepository.findByCount", query = "SELECT a FROM Arepository a WHERE a.count = :count"),
    @NamedQuery(name = "Arepository.findByComment", query = "SELECT a FROM Arepository a WHERE a.comment = :comment"),
    @NamedQuery(name = "Arepository.findByStatus", query = "SELECT a FROM Arepository a WHERE a.status = :status")})
public class Arepository implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count", nullable = false)
    private int count;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "repositoryId", fetch = FetchType.LAZY)
    private List<Atransaction> atransactionList;
    @JoinColumn(name = "repositorytypeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Arepositorytype repositorytypeId;
    @JoinColumn(name = "unitId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Aunit unitId;
    @JoinColumn(name = "propertyId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Aproperty propertyId;

    public Arepository() {
    }

    public Arepository(Integer id) {
        this.id = id;
    }

    public Arepository(Integer id, int count, String status) {
        this.id = id;
        this.count = count;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
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

    @XmlTransient
    public List<Atransaction> getAtransactionList() {
        return atransactionList;
    }

    public void setAtransactionList(List<Atransaction> atransactionList) {
        this.atransactionList = atransactionList;
    }

    public Arepositorytype getRepositorytypeId() {
        return repositorytypeId;
    }

    public void setRepositorytypeId(Arepositorytype repositorytypeId) {
        this.repositorytypeId = repositorytypeId;
    }

    public Aunit getUnitId() {
        return unitId;
    }

    public void setUnitId(Aunit unitId) {
        this.unitId = unitId;
    }

    public Aproperty getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Aproperty propertyId) {
        this.propertyId = propertyId;
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
        if (!(object instanceof Arepository)) {
            return false;
        }
        Arepository other = (Arepository) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Arepository[ id=" + id + " ]";
    }
    
}
