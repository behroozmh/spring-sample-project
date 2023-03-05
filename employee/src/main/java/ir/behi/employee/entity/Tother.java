/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.behi.employee.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * create User: behrooz.mh
 * Date: 3/5/2023
 * TIME: 1:24 PM
 **/
@Entity
@Table(name = "tother", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tother.findAll", query = "SELECT t FROM Tother t"),
    @NamedQuery(name = "Tother.findById", query = "SELECT t FROM Tother t WHERE t.id = :id"),
    @NamedQuery(name = "Tother.findByMainPart", query = "SELECT t FROM Tother t WHERE t.mainPart = :mainPart"),
    @NamedQuery(name = "Tother.findByPart", query = "SELECT t FROM Tother t WHERE t.part = :part"),
    @NamedQuery(name = "Tother.findByTelephone", query = "SELECT t FROM Tother t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "Tother.findByComment", query = "SELECT t FROM Tother t WHERE t.comment = :comment"),
    @NamedQuery(name = "Tother.findByStatus", query = "SELECT t FROM Tother t WHERE t.status = :status")})
public class Tother implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mainPart", nullable = false, length = 255)
    private String mainPart;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "part", nullable = false, length = 255)
    private String part;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telephone", nullable = false, length = 255)
    private String telephone;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    public Tother() {
    }

    public Tother(Integer id) {
        this.id = id;
    }

    public Tother(Integer id, String mainPart, String part, String telephone, String status) {
        this.id = id;
        this.mainPart = mainPart;
        this.part = part;
        this.telephone = telephone;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainPart() {
        return mainPart;
    }

    public void setMainPart(String mainPart) {
        this.mainPart = mainPart;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tother)) {
            return false;
        }
        Tother other = (Tother) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tother[ id=" + id + " ]";
    }
    
}
