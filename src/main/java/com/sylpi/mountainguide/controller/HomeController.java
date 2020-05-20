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
public class HomeController {

    private ArticleService articleService;

    @Autowired
    public HomeController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("/home")
    public String home(Model model){

        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);
        return "home";
    }


    @GetMapping("/stages")
    public String stages(){
        return "stages";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/photos")
    public String photos(){
        return "photos";
    }

    @GetMapping("/summer")
    public String summer(Model model){

        return "trainings/summer";
    }

    @GetMapping("/actus")
    public String news(Model model) {

        // get articles from DB with findAll from service
        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);

        // return html page that displays articles
        return "actus";
    }
}
