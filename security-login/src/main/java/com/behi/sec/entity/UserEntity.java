package com.behi.sec.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "USERS")
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @SequenceGenerator(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq")
    private Integer id;
    @Column(unique = true,nullable = false)
    private String uuid;
    @Column(unique = true,nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;

    private String firstname;
    private String lastname;
    private String mobile;

    private Boolean isEnabled;
    private Boolean isLocked;
    private Boolean isExpired;
    private Boolean isCredentials;

}
