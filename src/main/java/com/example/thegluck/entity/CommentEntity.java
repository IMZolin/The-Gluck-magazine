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
//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private List<ArticleEntity> articles;

    public CommentEntity(){}
    public CommentEntity(Long id) {
        this.id = id;

    }
}
