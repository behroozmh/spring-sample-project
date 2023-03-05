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
@Table(name = "atransaction", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Atransaction.findAll", query = "SELECT a FROM Atransaction a"),
    @NamedQuery(name = "Atransaction.findById", query = "SELECT a FROM Atransaction a WHERE a.id = :id"),
    @NamedQuery(name = "Atransaction.findByCount", query = "SELECT a FROM Atransaction a WHERE a.count = :count"),
    @NamedQuery(name = "Atransaction.findByIoType", query = "SELECT a FROM Atransaction a WHERE a.ioType = :ioType"),
    @NamedQuery(name = "Atransaction.findByDate", query = "SELECT a FROM Atransaction a WHERE a.date = :date"),
    @NamedQuery(name = "Atransaction.findByRegisterDate", query = "SELECT a FROM Atransaction a WHERE a.registerDate = :registerDate"),
    @NamedQuery(name = "Atransaction.findByClientOrEmployee", query = "SELECT a FROM Atransaction a WHERE a.clientOrEmployee = :clientOrEmployee"),
    @NamedQuery(name = "Atransaction.findByComment", query = "SELECT a FROM Atransaction a WHERE a.comment = :comment"),
    @NamedQuery(name = "Atransaction.findByStatus", query = "SELECT a FROM Atransaction a WHERE a.status = :status")})
public class Atransaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "count", nullable = false)
    private int count;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ioType", nullable = false)
    private boolean ioType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "date", nullable = false, length = 10)
    private String date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "registerDate", nullable = false, length = 10)
    private String registerDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clientOrEmployee", nullable = false)
    private boolean clientOrEmployee;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "status", nullable = false, length = 255)
    private String status;
    @JoinColumn(name = "employeeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employeeId;
    @JoinColumn(name = "clientId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Aclient clientId;
    @JoinColumn(name = "userId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Muser userId;
    @JoinColumn(name = "repositoryId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Arepository repositoryId;

    public Atransaction() {
    }

    public Atransaction(Long id) {
        this.id = id;
    }

    public Atransaction(Long id, int count, boolean ioType, String date, String registerDate, boolean clientOrEmployee, String status) {
        this.id = id;
        this.count = count;
        this.ioType = ioType;
        this.date = date;
        this.registerDate = registerDate;
        this.clientOrEmployee = clientOrEmployee;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean getIoType() {
        return ioType;
    }

    public void setIoType(boolean ioType) {
        this.ioType = ioType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public boolean getClientOrEmployee() {
        return clientOrEmployee;
    }

    public void setClientOrEmployee(boolean clientOrEmployee) {
        this.clientOrEmployee = clientOrEmployee;
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

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Aclient getClientId() {
        return clientId;
    }

    public void setClientId(Aclient clientId) {
        this.clientId = clientId;
    }

    public Muser getUserId() {
        return userId;
    }

    public void setUserId(Muser userId) {
        this.userId = userId;
    }

    public Arepository getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(Arepository repositoryId) {
        this.repositoryId = repositoryId;
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
        if (!(object instanceof Atransaction)) {
            return false;
        }
        Atransaction other = (Atransaction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Atransaction[ id=" + id + " ]";
    }
    
}
