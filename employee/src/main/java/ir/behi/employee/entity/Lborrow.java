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
@Table(name = "lborrow", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lborrow.findAll", query = "SELECT l FROM Lborrow l"),
    @NamedQuery(name = "Lborrow.findById", query = "SELECT l FROM Lborrow l WHERE l.id = :id"),
    @NamedQuery(name = "Lborrow.findByBorrowDate", query = "SELECT l FROM Lborrow l WHERE l.borrowDate = :borrowDate"),
    @NamedQuery(name = "Lborrow.findByComment", query = "SELECT l FROM Lborrow l WHERE l.comment = :comment"),
    @NamedQuery(name = "Lborrow.findByIsReturn", query = "SELECT l FROM Lborrow l WHERE l.isReturn = :isReturn"),
    @NamedQuery(name = "Lborrow.findByReturnDate", query = "SELECT l FROM Lborrow l WHERE l.returnDate = :returnDate"),
    @NamedQuery(name = "Lborrow.findByStatus", query = "SELECT l FROM Lborrow l WHERE l.status = :status")})
public class Lborrow implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "borrowDate", nullable = false, length = 10)
    private String borrowDate;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isReturn", nullable = false)
    private boolean isReturn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "returnDate", nullable = false, length = 10)
    private String returnDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Muser userId;
    @JoinColumn(name = "itemId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Litem itemId;
    @JoinColumn(name = "employeeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;

    public Lborrow() {
    }

    public Lborrow(Integer id) {
        this.id = id;
    }

    public Lborrow(Integer id, String borrowDate, boolean isReturn, String returnDate, String status) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.isReturn = isReturn;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean getIsReturn() {
        return isReturn;
    }

    public void setIsReturn(boolean isReturn) {
        this.isReturn = isReturn;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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

    public Litem getItemId() {
        return itemId;
    }

    public void setItemId(Litem itemId) {
        this.itemId = itemId;
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
        if (!(object instanceof Lborrow)) {
            return false;
        }
        Lborrow other = (Lborrow) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lborrow[ id=" + id + " ]";
    }
    
}
