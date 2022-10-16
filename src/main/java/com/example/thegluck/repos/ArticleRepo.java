package com.example.thegluck.repos;

import com.example.thegluck.entity.ArticleEntity;
import com.example.thegluck.entity.UserEntity;
import com.example.thegluck.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepo extends JpaRepository<ArticleEntity, Long> {
    List<ArticleEntity> findByTag(String tag);
    ArticleEntity findByTitle(String title);

}
