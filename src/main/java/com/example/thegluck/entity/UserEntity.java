package com.example.thegluck.entity;

import com.example.thegluck.model.ERole;
//import com.example.thegluck.model.Role;
import com.sun.istack.NotNull;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@ToString
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String first_name;
    private String last_name;
    private String password;
    private String username;
    private boolean active;
    @ElementCollection(targetClass = ERole.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<ERole> roles;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ArticleEntity> articles;

    /*public UserEntity(Long id, String username, String first_name, String last_name, String email, String password, boolean active) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.active = true;
        this.roles = Collections.singleton(ERole.USER);
    }*/

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    public String getFirst_name() {
        return first_name;
    }
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }
    public void setArticles(Set<ArticleEntity> articles) {
        this.articles = articles;
    }
    public boolean isActive() {
        return active;
    }
    public Set<ArticleEntity> getArticles() {
        return articles;
    }

    public String getPassword() {
        return password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<ERole> getRoles() {
        return roles;
    }

    public void setRoles(Set<ERole> roles) {
        this.roles = roles;
    }
    public UserEntity() {}
    public UserEntity(String username, String first_name, String last_name,String email, String password) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }
    public UserEntity(Long id,String username, String first_name, String last_name,String email, String password) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.active = true;
        this.roles = Collections.singleton(ERole.USER);
    }
    public static UserEntity of(String username,String first_name, String last_name, String email, String password) {
        return new UserEntity(null,username,first_name, last_name, email, password);
    }

    public void setActive(boolean active) {
        this.active = active;
    }

//    @Override
//    public String toString() {
//        return String.format(
//                "User[id=%, username='%s', email='%s', first_name='%s', last_name='%s'", id, username, email, first_name, last_name
//        );
//    }
}