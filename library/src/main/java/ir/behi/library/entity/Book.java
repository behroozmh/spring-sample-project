package ir.behi.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "Book")
@Table(name = "Book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_book")
    @SequenceGenerator(name = "seq_book", initialValue = 1, allocationSize = 1)
    private int id;
    private String name;
    private int isbn;
    private Date printDate;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Library> libraryList;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrowList;
}
