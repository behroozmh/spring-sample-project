package ir.behi.library.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * create User: behrooz.mh
 * Date: 12/20/2022
 * TIME: 10:05 AM
 **/
@Entity(name = "Person")
@Table(name = "Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @SequenceGenerator(name = "seq_category", initialValue = 1, allocationSize = 1)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(name = "national_code", length = 10)
    private int nationalCode;
    @Column(name = "id_num", length = 10)
    private String idNumber;

    @OneToMany(mappedBy = "person")
    private List<Borrow> borrowList;

}
