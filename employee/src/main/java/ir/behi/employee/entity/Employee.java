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
import javax.persistence.Lob;
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
@Table(name = "employee", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByAddress", query = "SELECT e FROM Employee e WHERE e.address = :address"),
    @NamedQuery(name = "Employee.findByCellphone", query = "SELECT e FROM Employee e WHERE e.cellphone = :cellphone"),
    @NamedQuery(name = "Employee.findByComment", query = "SELECT e FROM Employee e WHERE e.comment = :comment"),
    @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email"),
    @NamedQuery(name = "Employee.findByTheme", query = "SELECT e FROM Employee e WHERE e.theme = :theme"),
    @NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
    @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password"),
    @NamedQuery(name = "Employee.findByPersonalCode", query = "SELECT e FROM Employee e WHERE e.personalCode = :personalCode"),
    @NamedQuery(name = "Employee.findByStatus", query = "SELECT e FROM Employee e WHERE e.status = :status"),
    @NamedQuery(name = "Employee.findByTellphone", query = "SELECT e FROM Employee e WHERE e.tellphone = :tellphone"),
    @NamedQuery(name = "Employee.findByCabl", query = "SELECT e FROM Employee e WHERE e.cabl = :cabl"),
    @NamedQuery(name = "Employee.findByAnalog", query = "SELECT e FROM Employee e WHERE e.analog = :analog"),
    @NamedQuery(name = "Employee.findByDigital", query = "SELECT e FROM Employee e WHERE e.digital = :digital"),
    @NamedQuery(name = "Employee.findByEricson", query = "SELECT e FROM Employee e WHERE e.ericson = :ericson")})
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "address", length = 255)
    private String address;
    @Size(max = 255)
    @Column(name = "cellphone", length = 255)
    private String cellphone;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email", length = 255)
    private String email;
    @Size(max = 255)
    @Column(name = "theme", length = 255)
    private String theme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "personalCode", nullable = false, length = 255)
    private String personalCode;
    @Lob
    @Column(name = "pic")
    private byte[] pic;
    @Lob
    @Column(name = "signature")
    private byte[] signature;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Size(max = 255)
    @Column(name = "tellphone", length = 255)
    private String tellphone;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cabl", nullable = false)
    private boolean cabl;
    @Basic(optional = false)
    @NotNull
    @Column(name = "analog", nullable = false)
    private boolean analog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "digital", nullable = false)
    private boolean digital;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ericson", nullable = false)
    private boolean ericson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Atransaction> atransactionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Lborrow> lborrowList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Maccess> maccessList;
    @JoinColumn(name = "partId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Part partId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId", fetch = FetchType.LAZY)
    private List<Mleave> mleaveList;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String name, String password, String personalCode, String status, boolean cabl, boolean analog, boolean digital, boolean ericson) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.personalCode = personalCode;
        this.status = status;
        this.cabl = cabl;
        this.analog = analog;
        this.digital = digital;
        this.ericson = ericson;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setPersonalCode(String personalCode) {
        this.personalCode = personalCode;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public byte[] getSignature() {
        return signature;
    }

    public void setSignature(byte[] signature) {
        this.signature = signature;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTellphone() {
        return tellphone;
    }

    public void setTellphone(String tellphone) {
        this.tellphone = tellphone;
    }

    public boolean getCabl() {
        return cabl;
    }

    public void setCabl(boolean cabl) {
        this.cabl = cabl;
    }

    public boolean getAnalog() {
        return analog;
    }

    public void setAnalog(boolean analog) {
        this.analog = analog;
    }

    public boolean getDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public boolean getEricson() {
        return ericson;
    }

    public void setEricson(boolean ericson) {
        this.ericson = ericson;
    }

    @XmlTransient
    public List<Atransaction> getAtransactionList() {
        return atransactionList;
    }

    public void setAtransactionList(List<Atransaction> atransactionList) {
        this.atransactionList = atransactionList;
    }

    @XmlTransient
    public List<Lborrow> getLborrowList() {
        return lborrowList;
    }

    public void setLborrowList(List<Lborrow> lborrowList) {
        this.lborrowList = lborrowList;
    }

    @XmlTransient
    public List<Maccess> getMaccessList() {
        return maccessList;
    }

    public void setMaccessList(List<Maccess> maccessList) {
        this.maccessList = maccessList;
    }

    public Part getPartId() {
        return partId;
    }

    public void setPartId(Part partId) {
        this.partId = partId;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Employee[ id=" + id + " ]";
    }
    
}
