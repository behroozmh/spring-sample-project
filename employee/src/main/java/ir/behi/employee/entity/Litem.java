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
@Table(name = "litem", catalog = "easy", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Litem.findAll", query = "SELECT l FROM Litem l"),
    @NamedQuery(name = "Litem.findById", query = "SELECT l FROM Litem l WHERE l.id = :id"),
    @NamedQuery(name = "Litem.findByAuthor", query = "SELECT l FROM Litem l WHERE l.author = :author"),
    @NamedQuery(name = "Litem.findByComment", query = "SELECT l FROM Litem l WHERE l.comment = :comment"),
    @NamedQuery(name = "Litem.findByCount", query = "SELECT l FROM Litem l WHERE l.count = :count"),
    @NamedQuery(name = "Litem.findByIsbn", query = "SELECT l FROM Litem l WHERE l.isbn = :isbn"),
    @NamedQuery(name = "Litem.findByLanguage", query = "SELECT l FROM Litem l WHERE l.language = :language"),
    @NamedQuery(name = "Litem.findByNumber", query = "SELECT l FROM Litem l WHERE l.number = :number"),
    @NamedQuery(name = "Litem.findByPlace", query = "SELECT l FROM Litem l WHERE l.place = :place"),
    @NamedQuery(name = "Litem.findByPublisher", query = "SELECT l FROM Litem l WHERE l.publisher = :publisher"),
    @NamedQuery(name = "Litem.findByStatus", query = "SELECT l FROM Litem l WHERE l.status = :status"),
    @NamedQuery(name = "Litem.findByTitle", query = "SELECT l FROM Litem l WHERE l.title = :title"),
    @NamedQuery(name = "Litem.findByYear", query = "SELECT l FROM Litem l WHERE l.year = :year")})
public class Litem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 255)
    @Column(name = "author", length = 255)
    private String author;
    @Size(max = 255)
    @Column(name = "comment", length = 255)
    private String comment;
    @Column(name = "count")
    private Integer count;
    @Size(max = 255)
    @Column(name = "isbn", length = 255)
    private String isbn;
    @Size(max = 255)
    @Column(name = "language", length = 255)
    private String language;
    @Size(max = 255)
    @Column(name = "number", length = 255)
    private String number;
    @Size(max = 255)
    @Column(name = "place", length = 255)
    private String place;
    @Size(max = 255)
    @Column(name = "publisher", length = 255)
    private String publisher;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status", nullable = false, length = 8)
    private String status;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "summary", length = 2147483647)
    private String summary;
    @Size(max = 255)
    @Column(name = "title", length = 255)
    private String title;
    @Size(max = 4)
    @Column(name = "year", length = 4)
    private String year;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itemId", fetch = FetchType.LAZY)
    private List<Lborrow> lborrowList;
    @JoinColumn(name = "itemTypeId", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Litemtype itemTypeId;

    public Litem() {
    }

    public Litem(Integer id) {
        this.id = id;
    }

    public Litem(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @XmlTransient
    public List<Lborrow> getLborrowList() {
        return lborrowList;
    }

    public void setLborrowList(List<Lborrow> lborrowList) {
        this.lborrowList = lborrowList;
    }

    public Litemtype getItemTypeId() {
        return itemTypeId;
    }

    public void setItemTypeId(Litemtype itemTypeId) {
        this.itemTypeId = itemTypeId;
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
        if (!(object instanceof Litem)) {
            return false;
        }
        Litem other = (Litem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Litem[ id=" + id + " ]";
    }
    
}
