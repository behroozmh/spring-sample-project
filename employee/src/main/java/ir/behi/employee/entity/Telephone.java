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
@Table(name = "telephone", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telephone.findAll", query = "SELECT t FROM Telephone t"),
    @NamedQuery(name = "Telephone.findById", query = "SELECT t FROM Telephone t WHERE t.id = :id"),
    @NamedQuery(name = "Telephone.findByComment", query = "SELECT t FROM Telephone t WHERE t.comment = :comment"),
    @NamedQuery(name = "Telephone.findByDegree", query = "SELECT t FROM Telephone t WHERE t.degree = :degree"),
    @NamedQuery(name = "Telephone.findByName", query = "SELECT t FROM Telephone t WHERE t.name = :name"),
    @NamedQuery(name = "Telephone.findByOffice", query = "SELECT t FROM Telephone t WHERE t.office = :office"),
    @NamedQuery(name = "Telephone.findByPart", query = "SELECT t FROM Telephone t WHERE t.part = :part"),
    @NamedQuery(name = "Telephone.findByStatus", query = "SELECT t FROM Telephone t WHERE t.status = :status"),
    @NamedQuery(name = "Telephone.findByTelephone", query = "SELECT t FROM Telephone t WHERE t.telephone = :telephone")})
public class Telephone implements Serializable {
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
    @Column(name = "degree", nullable = false, length = 255)
    private String degree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "office", nullable = false, length = 255)
    private String office;
    @Size(max = 255)
    @Column(name = "part", length = 255)
    private String part;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "telephone", nullable = false, length = 255)
    private String telephone;

    public Telephone() {
    }

    public Telephone(Integer id) {
        this.id = id;
    }

    public Telephone(Integer id, String degree, String name, String office, String status, String telephone) {
        this.id = id;
        this.degree = degree;
        this.name = name;
        this.office = office;
        this.status = status;
        this.telephone = telephone;
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

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Telephone[ id=" + id + " ]";
    }
    
}
