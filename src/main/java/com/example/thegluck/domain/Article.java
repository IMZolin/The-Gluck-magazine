package com.example.thegluck.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String tag;
    private String title;
    private String description;
    private String text;
    public Article() {
    }
    public Article(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
    }
}
