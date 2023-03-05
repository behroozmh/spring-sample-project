/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.behi.employee.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "mleave", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mleave.findAll", query = "SELECT m FROM Mleave m"),
    @NamedQuery(name = "Mleave.findById", query = "SELECT m FROM Mleave m WHERE m.id = :id"),
    @NamedQuery(name = "Mleave.findByComment", query = "SELECT m FROM Mleave m WHERE m.comment = :comment"),
    @NamedQuery(name = "Mleave.findByEndDate", query = "SELECT m FROM Mleave m WHERE m.endDate = :endDate"),
    @NamedQuery(name = "Mleave.findByEndhour", query = "SELECT m FROM Mleave m WHERE m.endhour = :endhour"),
    @NamedQuery(name = "Mleave.findByEndminute", query = "SELECT m FROM Mleave m WHERE m.endminute = :endminute"),
    @NamedQuery(name = "Mleave.findByStartDate", query = "SELECT m FROM Mleave m WHERE m.startDate = :startDate"),
    @NamedQuery(name = "Mleave.findByStarthour", query = "SELECT m FROM Mleave m WHERE m.starthour = :starthour"),
    @NamedQuery(name = "Mleave.findByStartminute", query = "SELECT m FROM Mleave m WHERE m.startminute = :startminute"),
    @NamedQuery(name = "Mleave.findByHoliday", query = "SELECT m FROM Mleave m WHERE m.holiday = :holiday"),
    @NamedQuery(name = "Mleave.findByStatus", query = "SELECT m FROM Mleave m WHERE m.status = :status")})
public class Mleave implements Serializable {
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
    @Size(min = 1, max = 10)
    @Column(name = "endDate", nullable = false, length = 10)
    private String endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endhour", nullable = false)
    private int endhour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "endminute", nullable = false)
    private int endminute;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "startDate", nullable = false, length = 10)
    private String startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "starthour", nullable = false)
    private int starthour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "startminute", nullable = false)
    private int startminute;
    @Basic(optional = false)
    @NotNull
    @Column(name = "holiday", nullable = false)
    private int holiday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @JoinColumn(name = "mleaveTypeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mleavetype mleaveTypeId;
    @JoinColumn(name = "employeeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public Mleave() {
    }

    public Mleave(Integer id) {
        this.id = id;
    }

    public Mleave(Integer id, String endDate, int endhour, int endminute, String startDate, int starthour, int startminute, int holiday, String status) {
        this.id = id;
        this.endDate = endDate;
        this.endhour = endhour;
        this.endminute = endminute;
        this.startDate = startDate;
        this.starthour = starthour;
        this.startminute = startminute;
        this.holiday = holiday;
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

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getEndhour() {
        return endhour;
    }

    public void setEndhour(int endhour) {
        this.endhour = endhour;
    }

    public int getEndminute() {
        return endminute;
    }

    public void setEndminute(int endminute) {
        this.endminute = endminute;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getStarthour() {
        return starthour;
    }

    public void setStarthour(int starthour) {
        this.starthour = starthour;
    }

    public int getStartminute() {
        return startminute;
    }

    public void setStartminute(int startminute) {
        this.startminute = startminute;
    }

    public int getHoliday() {
        return holiday;
    }

    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Mleavetype getMleaveTypeId() {
        return mleaveTypeId;
    }

    public void setMleaveTypeId(Mleavetype mleaveTypeId) {
        this.mleaveTypeId = mleaveTypeId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Mleave)) {
            return false;
        }
        Mleave other = (Mleave) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mleave[ id=" + id + " ]";
    }
    
}
