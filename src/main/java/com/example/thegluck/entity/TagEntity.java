package com.example.thegluck.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class TagEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToMany(mappedBy = "tag")
    List<ArticleEntity> articles;
}
