package com.sylpi.mountainguide.service;

import com.sylpi.mountainguide.entity.Article;

import java.util.List;

public interface ArticleService {

    public List<Article> findAll();

    public Article findById(int theId);

    public void save (Article theArticle);

    public void deleteById(int theId);
}
