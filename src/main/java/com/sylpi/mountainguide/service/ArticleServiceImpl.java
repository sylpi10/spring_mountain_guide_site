package com.sylpi.mountainguide.service;

import com.sylpi.mountainguide.dao.ArticleRepository;
import com.sylpi.mountainguide.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService{

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository theArticleRepository){
        articleRepository = theArticleRepository;
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(int theId) {
        Optional<Article> result = articleRepository.findById(theId);

        Article theArticle = null;
        if (result.isPresent()){
            theArticle = result.get();
        }else{
            // didn't find article
            throw new RuntimeException("didn't find article with id " + theId);
        }
        return theArticle;
    }

    @Override
    public void save(Article theArticle) {
        articleRepository.save(theArticle);
    }

    @Override
    public void deleteById(int theId) {
        articleRepository.deleteById(theId);
    }

}
