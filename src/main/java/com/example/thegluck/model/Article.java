package com.example.thegluck.model;

import com.example.thegluck.entity.UserEntity;

import javax.persistence.*;

public class Article {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private UserEntity author;
    private String title;
    private String description;
}
