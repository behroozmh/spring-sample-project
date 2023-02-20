package ir.behi.oauth2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ROLE")
@Table(name = "ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleEntity {
    @Id
    @SequenceGenerator(name = "role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_seq")
    private Integer id;
    private String name;
    private String authority;

}
