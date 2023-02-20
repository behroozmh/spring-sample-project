package ir.behi.oauth2.resource.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USER_ROLES")
@Table(name = "USER_ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRolesEntity {
    @Id
    @SequenceGenerator(name = "user_role_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_role_seq")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;

}
