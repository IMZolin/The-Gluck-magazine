package com.example.thegluck.model;

import com.example.thegluck.entity.ArticleEntity;
import com.example.thegluck.entity.UserEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private String title;
    private String description;
    private LocalDateTime creationDate;
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getDescription() {
        return description;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public static Article toModel(ArticleEntity entity) {
        Article model = new Article();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setCreationDate(entity.getCreationDate());
        return model;
    }
}
