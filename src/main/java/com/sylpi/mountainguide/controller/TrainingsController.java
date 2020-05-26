package com.sylpi.mountainguide.controller;

import com.sylpi.mountainguide.entity.Article;
import com.sylpi.mountainguide.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class TrainingsController {

    private ArticleService articleService;

    @Autowired
    public TrainingsController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("stages")
    public String stages(){
        return "trainings/stages";
    }


    @GetMapping("alpinisme")
    public String alpi(Model model){
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);
        return "trainings/details/alpinisme";
    }

    @GetMapping("escalade")
    public String escalade(Model model){
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);
        return "trainings/details/escalade";
    }
}
