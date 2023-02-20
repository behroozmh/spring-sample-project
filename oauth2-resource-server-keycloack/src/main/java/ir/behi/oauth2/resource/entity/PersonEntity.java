package ir.behi.oauth2.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Person")
@Table(name = "Person")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @SequenceGenerator(name = "person_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    private Integer id;
    private String firstname;
    private String lastname;
    @Column(length = 10)
    private String nationalCode;
    @Lob
    private byte[] picture;
    private String description;
}
