package com.example.thegluck.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Article {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String title;
    private String text;
    private String tag;
    public Article() {
    }
    public Article(String title, String text, String tag) {
        this.title = title;
        this.text = text;
        this.tag = tag;
    }
}
