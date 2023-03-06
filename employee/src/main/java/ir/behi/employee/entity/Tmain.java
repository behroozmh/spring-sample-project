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
@Table(name = "tmain", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tmain.findAll", query = "SELECT t FROM Tmain t"),
    @NamedQuery(name = "Tmain.findById", query = "SELECT t FROM Tmain t WHERE t.id = :id"),
    @NamedQuery(name = "Tmain.findByMainPart", query = "SELECT t FROM Tmain t WHERE t.mainPart = :mainPart"),
    @NamedQuery(name = "Tmain.findByPart", query = "SELECT t FROM Tmain t WHERE t.part = :part"),
    @NamedQuery(name = "Tmain.findByCabl", query = "SELECT t FROM Tmain t WHERE t.cabl = :cabl"),
    @NamedQuery(name = "Tmain.findByAnalog", query = "SELECT t FROM Tmain t WHERE t.analog = :analog"),
    @NamedQuery(name = "Tmain.findByDigital", query = "SELECT t FROM Tmain t WHERE t.digital = :digital"),
    @NamedQuery(name = "Tmain.findByEricson", query = "SELECT t FROM Tmain t WHERE t.ericson = :ericson"),
    @NamedQuery(name = "Tmain.findByComment", query = "SELECT t FROM Tmain t WHERE t.comment = :comment"),
    @NamedQuery(name = "Tmain.findByStatus", query = "SELECT t FROM Tmain t WHERE t.status = :status")})
public class Tmain implements Serializable {
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
    @Size(max = 255)
    @Column(name = "cabl", length = 255)
    private String cabl;
    @Size(max = 255)
    @Column(name = "analog", length = 255)
    private String analog;
    @Size(max = 255)
    @Column(name = "digital", length = 255)
    private String digital;
    @Size(max = 255)
    @Column(name = "ericson", length = 255)
    private String ericson;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;

    public Tmain() {
    }

    public Tmain(Integer id) {
        this.id = id;
    }

    public Tmain(Integer id, String mainPart, String part, String status) {
        this.id = id;
        this.mainPart = mainPart;
        this.part = part;
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

    public String getCabl() {
        return cabl;
    }

    public void setCabl(String cabl) {
        this.cabl = cabl;
    }

    public String getAnalog() {
        return analog;
    }

    public void setAnalog(String analog) {
        this.analog = analog;
    }

    public String getDigital() {
        return digital;
    }

    public void setDigital(String digital) {
        this.digital = digital;
    }

    public String getEricson() {
        return ericson;
    }

    public void setEricson(String ericson) {
        this.ericson = ericson;
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
        if (!(object instanceof Tmain)) {
            return false;
        }
        Tmain other = (Tmain) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Tmain[ id=" + id + " ]";
    }
    
}
