package com.example.thegluck.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "comments")
public class CommentEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "article_id")
    private ArticleEntity article;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    private UserEntity author;
    public CommentEntity(){}
    public CommentEntity(Long id) {
        this.id = id;
    }
}
