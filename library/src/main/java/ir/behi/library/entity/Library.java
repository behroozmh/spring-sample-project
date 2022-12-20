package ir.behi.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Library")
@Table(name = "Library")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_library")
    @SequenceGenerator(name = "seq_library", initialValue = 1, allocationSize = 1)
    private Integer id;

    @ManyToOne
    private Book book;

    private Integer number;
    private Integer existNum;
    private Boolean isBorrowAble;
}
