package ir.behi.library.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:26 AM
 **/
@Entity(name = "Borrow")
@Table(name = "Borrow")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_borrow")
    @SequenceGenerator(name = "seq_borrow", initialValue = 1, allocationSize = 1)
    private Integer id;
    private Date rejDate;
    private Date receiveDate;

    @ManyToOne
    private Book book;
    @ManyToOne
    private Person person;
}
