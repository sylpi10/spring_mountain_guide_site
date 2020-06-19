package com.sylpi.mountainguide.controller;

import com.sylpi.mountainguide.entity.Article;
import com.sylpi.mountainguide.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("")
public class HomeController implements ErrorController {

    private static final String PATH = "/error";
    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    public String error(){
        return "no mapping available"; // doesn't seems to work
    }

    private ArticleService articleService;

    @Autowired
    public HomeController(ArticleService theArticleService){
        articleService = theArticleService;
    }

    @GetMapping("")
    public String homeindex(Model model){

        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);
        return "index";
    }

    @GetMapping("/index")
    public String home(Model model){

        List<Article> allArticles = articleService.findAll();
        model.addAttribute("articles", allArticles);
        return "index";
    }

    @GetMapping("login")
    public String login(){ return "login";}


}
