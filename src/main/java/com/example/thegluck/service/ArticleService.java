package com.example.thegluck.service;

import com.example.thegluck.entity.ArticleEntity;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.model.Article;
import com.example.thegluck.model.User;
import com.example.thegluck.repos.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired ArticleRepo articleRepo;
    public Article getById(long id){
        ArticleEntity article = articleRepo.findById(id).orElse(null);
        return Article.toModel(article);
    }
    public void delete(long id) {
        articleRepo.deleteById(id);
    }
    public Article getByTitle(String title) {
        ArticleEntity article = articleRepo.findByTitle(title);
        return Article.toModel(article);
    }
    public List<Article> getAll() {
        List<ArticleEntity> articles = articleRepo.findAll();
        List<Article> articles_model = new ArrayList<>();
        for (ArticleEntity article : articles){
            articles_model.add(Article.toModel(article));
        }
        return articles_model;
    }
    public Article editArticle(Article article_model) {
        ArticleEntity article = ArticleEntity.toEntity(article_model);
        return Article.toModel(articleRepo.saveAndFlush(article));
    }

}
