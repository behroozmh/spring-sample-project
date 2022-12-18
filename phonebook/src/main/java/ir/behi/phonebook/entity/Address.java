package ir.behi.phonebook.entity;

import javax.persistence.*;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String phone;
    private String address;
    @ManyToOne
    @JoinColumn(name ="f_person", referencedColumnName = "id")
    private Person person;
}
