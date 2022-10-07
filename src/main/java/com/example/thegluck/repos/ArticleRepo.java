package com.example.thegluck.repos;
import com.example.thegluck.domain.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepo {
    List<Article> findByTag(String tag);
    List<Article> findByTittle(String tittle);
}
