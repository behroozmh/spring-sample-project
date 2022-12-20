package ir.behi.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:00 AM
 **/
@Entity(name = "Category")
@Table(name = "Category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @SequenceGenerator(name = "seq_category", initialValue = 1, allocationSize = 1)
    private int id;
    @NotNull
    private String name;
    private Boolean isEnabled;

    @OneToMany(mappedBy = "category")
    private List<Book> bookList;
}
