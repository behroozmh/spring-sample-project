package ir.behi.library.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:11 AM
 **/
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
    private Integer number;
    private Integer existNum;
    private Boolean isBorrowAble;

    @ManyToOne
    private Book book;
}
