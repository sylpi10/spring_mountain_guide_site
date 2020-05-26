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
public class NewsController {

    private ArticleService articleService;

    @Autowired
    public NewsController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("/actus")
    public String stages(Model model){

        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);

        return "actus/actus";
    }
}
