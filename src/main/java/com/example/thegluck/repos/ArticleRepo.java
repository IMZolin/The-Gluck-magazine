package com.example.thegluck.repos;

import com.example.thegluck.entity.ArticleEntity;

import java.util.List;

public interface ArticleRepo {
    List<ArticleEntity> findByTag(String tag);
    List<ArticleEntity> findByTittle(String tittle);
}
