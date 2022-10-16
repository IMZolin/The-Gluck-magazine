package com.example.thegluck.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Table(name = "articles")
public class ArticleEntity {
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void setAuthor(UserEntity author) {
        this.author = author;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getId() {
        return id;
    }
    public String getTag() {
        return tag;
    }
    public UserEntity getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public String getText() {
        return text;
    }
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String tag;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity author;
    private String title;
    private String description;
    private String text;
    @ManyToMany
    @JoinTable(
            name = "article_likes",
            joinColumns = { @JoinColumn(name = "article_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id")}
    )
    private final Set<UserEntity> likes = new HashSet<>();
    public ArticleEntity() {}
    public ArticleEntity(String title, String text, String tag, String description) {
        this.title = title;
        this.text = text;
        this.tag = tag;
        this.description = description;
    }

}
