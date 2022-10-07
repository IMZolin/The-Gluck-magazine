package com.example.thegluck.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String fist_name;
    private String last_name;
    private String email;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;
    private String password;
    private boolean active;
    public User(){}
    public User(Long id, String username, String fist_name, String last_name, String email, String password) {
        this.id = id;
        this.username = username;
        this.fist_name = fist_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }
    @PersistenceConstructor
    private User(Long id, String username, String fist_name, String last_name, String email, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.fist_name = fist_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.active = active;
    }
    public static User of(String username, String fist_name, String last_name, String email, String password){
        return new User(null, username, fist_name, last_name, email, password, active);
    }
    @PersistenceConstructor
    private User(Long id, String username, String fist_name, String last_name, String email, Set<Role> roles, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.fist_name = fist_name;
        this.last_name = last_name;
        this.email = email;
        this.roles = roles;
        this.password = password;
        this.active = active;
    }


}
