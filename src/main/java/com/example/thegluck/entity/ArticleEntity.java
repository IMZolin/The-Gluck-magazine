package com.example.thegluck.entity;

import com.example.thegluck.model.Article;
import com.example.thegluck.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.ToString;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Table(name = "articles")
public class ArticleEntity {
    public void setId(Integer id) {
        this.id = id;
    }
//    public void setTag(String tag) {
//        this.tag = tag;
//    }
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
//    public String getTag() {
//        return tag;
//    }
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
    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinTable(name = "tag_article")
    TagEntity tag;
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
    @OneToMany(mappedBy = "article", orphanRemoval = true)
    private List<CommentEntity> comments;
    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationDate;

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
    public Set<UserEntity> getLikes() {
        return likes;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public ArticleEntity() {}
    public ArticleEntity(String title, String text, String tag, String description) {
        this.title = title;
        this.text = text;
        this.description = description;
    }
    public static ArticleEntity toEntity(Article model) {
        ArticleEntity entity = new ArticleEntity();
        entity.setId(model.getId());
        entity.setTitle(model.getTitle());
        entity.setDescription(model.getDescription());
        model.setCreationDate(entity.getCreationDate());
        return entity;
    }

}
