package com.sylpi.crudapp.dao;

import com.sylpi.crudapp.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

//    public List<Article> findAllByOrderTitleAsc();
}
