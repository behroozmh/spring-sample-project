package ir.behi.phonebook.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String mobile;
    @Lob
    private String picture;
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "person")
    private List<Address> addressList;
}
