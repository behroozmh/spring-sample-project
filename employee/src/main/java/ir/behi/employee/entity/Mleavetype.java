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
@Table(name = "mleavetype", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mleavetype.findAll", query = "SELECT m FROM Mleavetype m"),
    @NamedQuery(name = "Mleavetype.findById", query = "SELECT m FROM Mleavetype m WHERE m.id = :id"),
    @NamedQuery(name = "Mleavetype.findByComment", query = "SELECT m FROM Mleavetype m WHERE m.comment = :comment"),
    @NamedQuery(name = "Mleavetype.findByIsMain", query = "SELECT m FROM Mleavetype m WHERE m.isMain = :isMain"),
    @NamedQuery(name = "Mleavetype.findByIsGuard", query = "SELECT m FROM Mleavetype m WHERE m.isGuard = :isGuard"),
    @NamedQuery(name = "Mleavetype.findByName", query = "SELECT m FROM Mleavetype m WHERE m.name = :name"),
    @NamedQuery(name = "Mleavetype.findByStatus", query = "SELECT m FROM Mleavetype m WHERE m.status = :status")})
public class Mleavetype implements Serializable {
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
    @Column(name = "isMain", nullable = false)
    private boolean isMain;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isGuard", nullable = false)
    private boolean isGuard;
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
    @JoinColumn(name = "muserId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Muser muserId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mleaveTypeId", fetch = FetchType.LAZY)
    private List<Mleave> mleaveList;

    public Mleavetype() {
    }

    public Mleavetype(Integer id) {
        this.id = id;
    }

    public Mleavetype(Integer id, boolean isMain, boolean isGuard, String name, String status) {
        this.id = id;
        this.isMain = isMain;
        this.isGuard = isGuard;
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

    public boolean getIsMain() {
        return isMain;
    }

    public void setIsMain(boolean isMain) {
        this.isMain = isMain;
    }

    public boolean getIsGuard() {
        return isGuard;
    }

    public void setIsGuard(boolean isGuard) {
        this.isGuard = isGuard;
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

    public Muser getMuserId() {
        return muserId;
    }

    public void setMuserId(Muser muserId) {
        this.muserId = muserId;
    }

    @XmlTransient
    public List<Mleave> getMleaveList() {
        return mleaveList;
    }

    public void setMleaveList(List<Mleave> mleaveList) {
        this.mleaveList = mleaveList;
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
        if (!(object instanceof Mleavetype)) {
            return false;
        }
        Mleavetype other = (Mleavetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mleavetype[ id=" + id + " ]";
    }
    
}
