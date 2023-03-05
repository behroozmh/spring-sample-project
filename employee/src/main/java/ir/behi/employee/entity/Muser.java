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
@Table(name = "muser", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Muser.findAll", query = "SELECT m FROM Muser m"),
    @NamedQuery(name = "Muser.findById", query = "SELECT m FROM Muser m WHERE m.id = :id"),
    @NamedQuery(name = "Muser.findByActive", query = "SELECT m FROM Muser m WHERE m.active = :active"),
    @NamedQuery(name = "Muser.findByAdmin", query = "SELECT m FROM Muser m WHERE m.admin = :admin"),
    @NamedQuery(name = "Muser.findByComment", query = "SELECT m FROM Muser m WHERE m.comment = :comment"),
    @NamedQuery(name = "Muser.findByCreateDate", query = "SELECT m FROM Muser m WHERE m.createDate = :createDate"),
    @NamedQuery(name = "Muser.findByLastLoginDate", query = "SELECT m FROM Muser m WHERE m.lastLoginDate = :lastLoginDate"),
    @NamedQuery(name = "Muser.findByLastPasschangeDate", query = "SELECT m FROM Muser m WHERE m.lastPasschangeDate = :lastPasschangeDate"),
    @NamedQuery(name = "Muser.findByLogincount", query = "SELECT m FROM Muser m WHERE m.logincount = :logincount"),
    @NamedQuery(name = "Muser.findByName", query = "SELECT m FROM Muser m WHERE m.name = :name"),
    @NamedQuery(name = "Muser.findByOperator", query = "SELECT m FROM Muser m WHERE m.operator = :operator"),
    @NamedQuery(name = "Muser.findByPassword", query = "SELECT m FROM Muser m WHERE m.password = :password"),
    @NamedQuery(name = "Muser.findByLibrary", query = "SELECT m FROM Muser m WHERE m.library = :library"),
    @NamedQuery(name = "Muser.findByReport", query = "SELECT m FROM Muser m WHERE m.report = :report"),
    @NamedQuery(name = "Muser.findByAmval", query = "SELECT m FROM Muser m WHERE m.amval = :amval"),
    @NamedQuery(name = "Muser.findByStatus", query = "SELECT m FROM Muser m WHERE m.status = :status"),
    @NamedQuery(name = "Muser.findByTheme", query = "SELECT m FROM Muser m WHERE m.theme = :theme"),
    @NamedQuery(name = "Muser.findByUsername", query = "SELECT m FROM Muser m WHERE m.username = :username"),
    @NamedQuery(name = "Muser.findByTelephone", query = "SELECT m FROM Muser m WHERE m.telephone = :telephone")})
public class Muser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private boolean active;
    @Basic(optional = false)
    @NotNull
    @Column(name = "admin", nullable = false)
    private boolean admin;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Size(max = 10)
    @Column(name = "createDate", length = 10)
    private String createDate;
    @Size(max = 10)
    @Column(name = "lastLoginDate", length = 10)
    private String lastLoginDate;
    @Size(max = 10)
    @Column(name = "lastPasschangeDate", length = 10)
    private String lastPasschangeDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logincount", nullable = false)
    private short logincount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "operator", nullable = false)
    private boolean operator;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "library", nullable = false)
    private boolean library;
    @Basic(optional = false)
    @NotNull
    @Column(name = "report", nullable = false)
    private boolean report;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amval", nullable = false)
    private boolean amval;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "theme", nullable = false, length = 255)
    private String theme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telephone", nullable = false)
    private boolean telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Arepositorytype> arepositorytypeList;
    @JoinColumn(name = "departmentId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department departmentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Atransaction> atransactionList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Litemtype> litemtypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Aunit> aunitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Lborrow> lborrowList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Aclient> aclientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muserId", fetch = FetchType.LAZY)
    private List<Maccess> maccessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Astore> astoreList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muserId", fetch = FetchType.LAZY)
    private List<Mleavetype> mleavetypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<Apropertygroup> apropertygroupList;

    public Muser() {
    }

    public Muser(Integer id) {
        this.id = id;
    }

    public Muser(Integer id, boolean active, boolean admin, short logincount, String name, boolean operator, String password, boolean library, boolean report, boolean amval, String status, String theme, String username, boolean telephone) {
        this.id = id;
        this.active = active;
        this.admin = admin;
        this.logincount = logincount;
        this.name = name;
        this.operator = operator;
        this.password = password;
        this.library = library;
        this.report = report;
        this.amval = amval;
        this.status = status;
        this.theme = theme;
        this.username = username;
        this.telephone = telephone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(String lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getLastPasschangeDate() {
        return lastPasschangeDate;
    }

    public void setLastPasschangeDate(String lastPasschangeDate) {
        this.lastPasschangeDate = lastPasschangeDate;
    }

    public short getLogincount() {
        return logincount;
    }

    public void setLogincount(short logincount) {
        this.logincount = logincount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getOperator() {
        return operator;
    }

    public void setOperator(boolean operator) {
        this.operator = operator;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getLibrary() {
        return library;
    }

    public void setLibrary(boolean library) {
        this.library = library;
    }

    public boolean getReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public boolean getAmval() {
        return amval;
    }

    public void setAmval(boolean amval) {
        this.amval = amval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getTelephone() {
        return telephone;
    }

    public void setTelephone(boolean telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public List<Arepositorytype> getArepositorytypeList() {
        return arepositorytypeList;
    }

    public void setArepositorytypeList(List<Arepositorytype> arepositorytypeList) {
        this.arepositorytypeList = arepositorytypeList;
    }

    public Department getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Department departmentId) {
        this.departmentId = departmentId;
    }

    @XmlTransient
    public List<Atransaction> getAtransactionList() {
        return atransactionList;
    }

    public void setAtransactionList(List<Atransaction> atransactionList) {
        this.atransactionList = atransactionList;
    }

    @XmlTransient
    public List<Litemtype> getLitemtypeList() {
        return litemtypeList;
    }

    public void setLitemtypeList(List<Litemtype> litemtypeList) {
        this.litemtypeList = litemtypeList;
    }

    @XmlTransient
    public List<Aunit> getAunitList() {
        return aunitList;
    }

    public void setAunitList(List<Aunit> aunitList) {
        this.aunitList = aunitList;
    }

    @XmlTransient
    public List<Lborrow> getLborrowList() {
        return lborrowList;
    }

    public void setLborrowList(List<Lborrow> lborrowList) {
        this.lborrowList = lborrowList;
    }

    @XmlTransient
    public List<Aclient> getAclientList() {
        return aclientList;
    }

    public void setAclientList(List<Aclient> aclientList) {
        this.aclientList = aclientList;
    }

    @XmlTransient
    public List<Maccess> getMaccessList() {
        return maccessList;
    }

    public void setMaccessList(List<Maccess> maccessList) {
        this.maccessList = maccessList;
    }

    @XmlTransient
    public List<Astore> getAstoreList() {
        return astoreList;
    }

    public void setAstoreList(List<Astore> astoreList) {
        this.astoreList = astoreList;
    }

    @XmlTransient
    public List<Mleavetype> getMleavetypeList() {
        return mleavetypeList;
    }

    public void setMleavetypeList(List<Mleavetype> mleavetypeList) {
        this.mleavetypeList = mleavetypeList;
    }

    @XmlTransient
    public List<Apropertygroup> getApropertygroupList() {
        return apropertygroupList;
    }

    public void setApropertygroupList(List<Apropertygroup> apropertygroupList) {
        this.apropertygroupList = apropertygroupList;
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
        if (!(object instanceof Muser)) {
            return false;
        }
        Muser other = (Muser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Muser[ id=" + id + " ]";
    }
    
}
